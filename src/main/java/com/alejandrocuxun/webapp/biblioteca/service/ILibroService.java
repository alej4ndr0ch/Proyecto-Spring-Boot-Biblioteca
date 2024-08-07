package com.alejandrocuxun.webapp.biblioteca.service;

import java.util.List;

import com.alejandrocuxun.webapp.biblioteca.model.Libro;

public interface ILibroService {
    public List<Libro> listarLibros();

    public Libro buscarLibroPorId(Long Id);

    public Libro guardarLibro(Libro libro);

    public void eliminarLibro(Libro libro);
}
