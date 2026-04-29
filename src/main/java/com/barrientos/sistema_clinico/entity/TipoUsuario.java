package com.barrientos.sistema_clinico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipousuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoUsuario",unique = true)
    private int id;

    @Column(name = "tipo_usu", nullable = false)
    private String tipoUsuario;
}
