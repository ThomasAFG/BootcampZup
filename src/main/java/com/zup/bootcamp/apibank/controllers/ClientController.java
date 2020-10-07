package com.zup.bootcamp.apibank.controllers;

import com.zup.bootcamp.apibank.dto.ClientAddressDTO;
import com.zup.bootcamp.apibank.dto.ClientBasicDTO;
import com.zup.bootcamp.apibank.dto.ClientImgDTO;
import com.zup.bootcamp.apibank.entities.Client;
import com.zup.bootcamp.apibank.repository.AccountRepository;
import com.zup.bootcamp.apibank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    @ResponseBody
    @PostMapping(value = "/clients", consumes = "application/json")
    public ResponseEntity<?> addClientBasic(@RequestBody @Valid ClientBasicDTO client, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if(clientRepository.existsByCpf(client.getCpf())){
            return ResponseEntity.badRequest().body("{ \"message\" = \"CPF já cadastrado!\"} ");
        }
        if(clientRepository.existsByEmail(client.getEmail())){
            return ResponseEntity.badRequest().body("{ \"message\" = \"Email já cadastrado!\"} ");
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/clients").path("/address").build().toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @ResponseBody
    @PostMapping(value = "/address", consumes = "application/json")
    public ResponseEntity<?> addClientAddress(@RequestBody @Valid ClientAddressDTO client, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if(clientRepository.existsByCpf(client.getBasicInfo().getCpf())){
            return ResponseEntity.badRequest().body("{ \"message\" = \"CPF já cadastrado!\"} ");
        }
        if(clientRepository.existsByEmail(client.getBasicInfo().getEmail())){
            return ResponseEntity.badRequest().body("{ \"message\" = \"Email já cadastrado!\"} ");
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/address").path("/img").build().toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @ResponseBody
    @PostMapping(value = "/img", consumes = "application/json")
    public ResponseEntity<?> addClientImg(@RequestBody @Valid ClientImgDTO client, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if(clientRepository.existsByCpf(client.getBasicInfo().getCpf())){
            return ResponseEntity.badRequest().body("{ \"message\" = \"CPF já cadastrado!\"} ");
        }
        if(clientRepository.existsByEmail(client.getBasicInfo().getEmail())){
            return ResponseEntity.badRequest().body("{ \"message\" = \"Email já cadastrado!\"} ");
        }
        try{
            Client savedClient = new Client(client);
            HttpEntity<byte[]> imgFront = downloadImg(client.getPathFrontImg(), "/home/thomasafg/Zup/apibank/src/main/storage/front", client.getBasicInfo().getEmail());
            savedClient.setPathFrontImg("/home/thomasafg/Zup/apibank/src/main/storage/front/"+savedClient.getEmail()+".jpg");
            Files.write(Paths.get(savedClient.getPathFrontImg()), imgFront.getBody());
            if (!client.getPathBackImg().equals("")) {
                HttpEntity<byte[]> imgBack = downloadImg(client.getPathBackImg(), "/home/thomasafg/Zup/apibank/src/main/storage/back", client.getBasicInfo().getEmail());
                savedClient.setPathBackImg("/home/thomasafg/Zup/apibank/src/main/storage/back/" + savedClient.getEmail() + ".jpg");
                Files.write(Paths.get(savedClient.getPathBackImg()), imgBack.getBody());
            }
            clientRepository.save(savedClient);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/img").path("/{id}").buildAndExpand(savedClient.getId().toString()).toUri();
            return ResponseEntity.created(uri).body(savedClient);
        }
        catch(IOException e){
            return ResponseEntity.unprocessableEntity().body("Não foi possível salvar o cliente no banco de dados!");
        }
    }

    @GetMapping(value = "/upload")
    public HttpEntity<byte[]> downloadImg(String imageName, String path, String email) throws IOException {
        byte[] arquivo = Files.readAllBytes( Paths.get(imageName) );
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename="+path+"\""+email+".jpg\"");
        return new HttpEntity<byte[]>( arquivo, httpHeaders);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> myListClients(){
        return ResponseEntity.ok().body(clientRepository.findAll());
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<Client> myGetClientById(@PathVariable Long id){
        return ResponseEntity.ok().body(clientRepository.findById(id).get());
    }

    @ResponseBody
    @GetMapping("/cpf:{cpf}")
    public ResponseEntity<Client> myGetClientByCPF(@PathVariable String cpf){
        return ResponseEntity.ok().body(clientRepository.findByCpf(cpf).get(0));
    }

    @ResponseBody
    @GetMapping("/email:{email}")
    public ResponseEntity<Client> myGetClientByEmail(@PathVariable String email){
        return ResponseEntity.ok().body(clientRepository.findByEmail(email).get(0));
    }
}
