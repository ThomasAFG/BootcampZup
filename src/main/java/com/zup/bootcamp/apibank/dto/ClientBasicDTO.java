package com.zup.bootcamp.apibank.dto;

import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


@AllArgsConstructor
public class ClientBasicDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
