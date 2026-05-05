package com.barrientos.sistema_clinico.service;

import com.barrientos.sistema_clinico.dto.MenuGrupoDto;
import com.barrientos.sistema_clinico.entity.MenuGroup;

import java.util.List;

public interface IMenuGroupService {
    List<MenuGroup> findAll(); //V1.1

}
