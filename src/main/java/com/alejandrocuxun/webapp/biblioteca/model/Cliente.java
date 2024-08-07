package com.alejandrocuxun.webapp.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Cliente  {
    @Id
    private Long dpi;
    private String nombreCliente;
    private String apellidoCliente;
    private String telefono;
}
