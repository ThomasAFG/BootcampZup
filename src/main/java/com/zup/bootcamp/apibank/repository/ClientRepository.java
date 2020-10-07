package com.zup.bootcamp.apibank.repository;

import com.zup.bootcamp.apibank.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByCpf(String cpf);

    List<Client> findByEmail(String email);

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

}
