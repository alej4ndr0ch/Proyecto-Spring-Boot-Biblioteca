package com.alejandrocuxun.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandrocuxun.webapp.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
