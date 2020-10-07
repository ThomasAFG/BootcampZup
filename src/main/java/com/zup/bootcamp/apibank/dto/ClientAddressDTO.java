package com.zup.bootcamp.apibank.dto;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@AllArgsConstructor
public class ClientAddressDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private ClientBasicDTO basicInfo;

    @NotBlank(message = "Campo obrigatório!")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato CEP inválido!")
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

    public ClientBasicDTO getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(ClientBasicDTO basicInfo) {
        this.basicInfo = basicInfo;
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
}
