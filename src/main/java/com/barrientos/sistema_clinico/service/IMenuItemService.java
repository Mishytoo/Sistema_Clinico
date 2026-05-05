package com.barrientos.sistema_clinico.service;

import com.barrientos.sistema_clinico.dto.MenuGrupoDto;
import com.barrientos.sistema_clinico.entity.MenuItem;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMenuItemService {
    List<MenuItem> findAll(); //V1.1

    List<MenuItem> findMenuItemsByTipoUsuario(Long idTipoUsuario);

    List<MenuGrupoDto> findMenuAgrupadoByTipoUsuario(Long idTipoUsuario);
}
