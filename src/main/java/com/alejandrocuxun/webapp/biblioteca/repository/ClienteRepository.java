package com.alejandrocuxun.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandrocuxun.webapp.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
