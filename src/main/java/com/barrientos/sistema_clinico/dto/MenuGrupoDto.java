package com.barrientos.sistema_clinico.dto;

import java.util.List;

public record MenuGrupoDto(
        Long id,
        String nombre,
        String icono,
        Integer orden,
        List<MenuItemDto> items
) {
}