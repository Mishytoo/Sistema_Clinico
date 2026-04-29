package com.barrientos.sistema_clinico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private int id;

    @Column(name = "tipo_documento", nullable = false)
    private String tipoDocumento;

    @Column(name = "nro_documento", nullable = false)
    private String nroDocumento;

    @Column(name = "nom_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "ape_completo", nullable = false)
    private String apellidoCompleto;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "celular", nullable = false)
    private String celular;

    @Column(name = "fec_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "direccion", columnDefinition = "TEXT")
    private String direccion;

    public Persona(String tipoDocumento, String nroDocumento, String nombreCompleto, String apellidoCompleto, String sexo, String celular, LocalDate fechaNacimiento, String direccion) {
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.apellidoCompleto = apellidoCompleto;
        this.sexo = sexo;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }
}
