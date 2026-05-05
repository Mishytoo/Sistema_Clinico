package com.barrientos.sistema_clinico.service.impl;

import com.barrientos.sistema_clinico.dto.MenuGrupoDto;
import com.barrientos.sistema_clinico.dto.MenuItemDto;
import com.barrientos.sistema_clinico.entity.MenuGroup;
import com.barrientos.sistema_clinico.entity.MenuItem;
import com.barrientos.sistema_clinico.repository.IMenuGroupDao;
import com.barrientos.sistema_clinico.service.IMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuGroupServiceImpl implements IMenuGroupService {

    @Autowired
    private IMenuGroupDao menuGroupDao;

    @Override
    @Transactional(readOnly = true)
    public List<MenuGroup> findAll() {
        return menuGroupDao.findAll();
    }



}
