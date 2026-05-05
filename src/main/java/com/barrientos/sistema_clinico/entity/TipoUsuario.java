package com.barrientos.sistema_clinico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="tipos_usuario")
public class TipoUsuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private Long id;

    @Column(name = "tipo_usu")
    private String tipoUsuario;

    @Column(name = "codigo_rol")
    private String codigoRol;

    @OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL)
    private List<Acceso> accesos;

    public TipoUsuario() {
        usuarios = new ArrayList<>();
    }
}
