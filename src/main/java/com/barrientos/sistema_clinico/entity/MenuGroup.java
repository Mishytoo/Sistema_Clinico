package com.barrientos.sistema_clinico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="menu_grupos")
public class MenuGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_grupo")
    private long id;

    @Column
    private String nombre;
    @Column
    private String icono;
    @Column
    private int orden;
    @Column
    private int estado;

    @OneToMany(mappedBy = "menuGroup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;



}
