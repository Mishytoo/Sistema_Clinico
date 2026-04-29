package com.barrientos.sistema_clinico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", unique = true)
    private int id;

    @Column(name = "nom_usu", nullable = false)
    private String nombre;

    @Column(name = "clave_usu", nullable = false)
    private String contrasena;


    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime createAt;


    @Column(name = "hora_creacion", nullable = false, updatable = false)
    private LocalTime horaCreacion;

    public Usuario(String nombre, String contrasena) {
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    // Funcion para actualizar los registros
    @PrePersist
    public void onUpdate() {
        this.horaCreacion = LocalTime.now();
        this.createAt = LocalDateTime.now();
    }

}
