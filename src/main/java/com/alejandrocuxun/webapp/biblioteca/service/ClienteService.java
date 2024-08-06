package com.alejandrocuxun.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alejandrocuxun.webapp.biblioteca.model.Cliente;
import com.alejandrocuxun.webapp.biblioteca.repository.ClienteRepository;

public class ClienteService implements IClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Long dpi) {
        return clienteRepository.findById(dpi).orElse(null);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}