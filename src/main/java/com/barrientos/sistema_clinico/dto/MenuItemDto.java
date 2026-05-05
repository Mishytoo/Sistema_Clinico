package com.barrientos.sistema_clinico.dto;
public record MenuItemDto(
        Long id,
        String nombre,
        String categoria,
        String valor,
        String icono,
        Integer orden
) {
}