package com.barrientos.sistema_clinico.util;

import com.barrientos.sistema_clinico.dto.MenuGrupoDto;
import com.barrientos.sistema_clinico.dto.MenuItemDto;
import org.springframework.stereotype.Component;

@Component("menuHelper")
public class MenuHelper {

    public String url(MenuItemDto item) {
        if (item == null || item.valor() == null || item.valor().isBlank()) {
            return "#";
        }

        String valor = limpiar(item.valor());

        if (item.categoria() == null || item.categoria().isBlank()) {
            return "/" + valor;
        }

        String categoria = limpiar(item.categoria());

        return "/" + categoria + "/" + valor;
    }

    public boolean itemActivo(MenuItemDto item, String currentPath) {
        if (item == null || currentPath == null) {
            return false;
        }

        String itemUrl = url(item);
        return currentPath.equals(itemUrl);
    }

    public boolean grupoActivo(MenuGrupoDto grupo, String currentPath) {
        if (grupo == null || grupo.items() == null || currentPath == null) {
            return false;
        }

        return grupo.items()
                .stream()
                .anyMatch(item -> itemActivo(item, currentPath));
    }

    private String limpiar(String valor) {
        return valor.replaceAll("^/+", "").replaceAll("/+$", "");
    }
}