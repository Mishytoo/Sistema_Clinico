package com.barrientos.sistema_clinico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="menu_items")
public class MenuItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_item")
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_grupos_id_menu_grupo")
    private MenuGroup menuGroup;

    @Column
    private String nombre;
    @Column
    private String categoria;
    @Column
    private String valor;
    @Column
    private String icono;
    @Column
    private int orden;
    @Column
    private int estado;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    private List<Acceso> acceso;
}
