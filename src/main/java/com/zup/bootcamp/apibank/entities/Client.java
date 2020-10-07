package com.zup.bootcamp.apibank.entities;


import com.zup.bootcamp.apibank.dto.ClientAddressDTO;
import com.zup.bootcamp.apibank.dto.ClientBasicDTO;
import com.zup.bootcamp.apibank.dto.ClientImgDTO;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "CLIENTS")
@Data
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Campo obrigatório!")
    private String firstName;

    @NotBlank(message = "Campo obrigatório!")
    private String lastName;

    @NotBlank(message = "Campo obrigatório!")
    @Email(message = "Formato do Email inválido!")
    private String email;

    @NotBlank(message = "Campo obrigatório!")
    @CPF(message = "Formato do CPF inválido!")
    private String cpf;

    @NotBlank(message = "Campo obrigatório!")
    @Pattern(regexp = "\\d{11}", message = "Formato da CNH inválido!")
    private String cnh;

    @NotBlank(message = "Campo obrigatório!")
    private String birthDate;

    @NotBlank(message = "Campo obrigatório!")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato do CEP inválido!")
    private String cep;

    @NotBlank(message = "Campo obrigatório!")
    private String street;

    @NotBlank(message = "Campo obrigatório!")
    private String district;

    @NotNull
    private String complement;

    @NotBlank(message = "Campo obrigatório!")
    private String city;

    @NotBlank(message = "Campo obrigatório!")
    private String state;

    @NotBlank(message = "Campo obrigatório!")
    private String pathFrontImg;

    @NotNull
    private String pathBackImg;

    public Client(ClientImgDTO clientInfo) {
        this.firstName = clientInfo.getBasicInfo().getFirstName();
        this.lastName = clientInfo.getBasicInfo().getLastName();
        this.email = clientInfo.getBasicInfo().getEmail();
        this.cpf = clientInfo.getBasicInfo().getCpf();
        this.cnh = clientInfo.getBasicInfo().getCnh();
        this.birthDate = clientInfo.getBasicInfo().getBirthDate();
        this.cep = clientInfo.getAddressInfo().getCep();
        this.street = clientInfo.getAddressInfo().getStreet();
        this.district = clientInfo.getAddressInfo().getDistrict();
        this.complement = clientInfo.getAddressInfo().getComplement();
        this.city = clientInfo.getAddressInfo().getCity();
        this.state = clientInfo.getAddressInfo().getState();
        this.pathFrontImg = clientInfo.getPathFrontImg();
        this.pathBackImg = clientInfo.getPathBackImg();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPathFrontImg() {
        return pathFrontImg;
    }

    public void setPathFrontImg(String pathFrontImg) {
        this.pathFrontImg = pathFrontImg;
    }

    public String getPathBackImg() {
        return pathBackImg;
    }

    public void setPathBackImg(String pathBackImg) {
        this.pathBackImg = pathBackImg;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
