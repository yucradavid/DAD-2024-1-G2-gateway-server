package com.example.mscliente.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correoElectronico;
    private String direccion;


}
