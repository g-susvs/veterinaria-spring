package com.veterianariaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "veterinarias")
public class Veterinaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veterinaria_id", nullable = false, unique = true)
    private int id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 255, unique = true)
    private String correo;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 255)
    private String direccion;

    private String imagen;

    private int destacado = 1;
}
