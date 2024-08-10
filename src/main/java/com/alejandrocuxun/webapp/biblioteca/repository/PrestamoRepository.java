package com.alejandrocuxun.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandrocuxun.webapp.biblioteca.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{

}
