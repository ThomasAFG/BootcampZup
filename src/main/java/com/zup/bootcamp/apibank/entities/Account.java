package com.zup.bootcamp.apibank.entities;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNTS")
@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Campo obrigatório!")
    private String accountNumber;

    @NotBlank(message = "Campo obrigatório!")
    private String agency;

    @NotBlank(message = "Campo obrigatório!")
    private String bankCode;

    @NotNull
    private String balance;

    @NotBlank(message = "Campo obrigatório!")
    private Long idClient;
}
