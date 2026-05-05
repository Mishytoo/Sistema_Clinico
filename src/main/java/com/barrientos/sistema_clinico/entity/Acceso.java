package com.barrientos.sistema_clinico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name="tipos_usuario_menu_items")
@IdClass(AccesoId.class)
public class Acceso implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipos_usuario_id_tipo_usuario")
    private TipoUsuario tipoUsuario;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_items_id_menu_item")
    private MenuItem menuItem;
}
