package com.barrientos.sistema_clinico.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class AccesoId implements Serializable {

    private Long tipoUsuario;
    private Long menuItem;

    public AccesoId() {
    }

    public AccesoId(Long tipoUsuario, Long menuItem) {
        this.tipoUsuario = tipoUsuario;
        this.menuItem = menuItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccesoId accesoId)) return false;
        return Objects.equals(tipoUsuario, accesoId.tipoUsuario)
                && Objects.equals(menuItem, accesoId.menuItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoUsuario, menuItem);
    }
}