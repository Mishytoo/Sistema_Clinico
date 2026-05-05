package com.barrientos.sistema_clinico.service.impl;

import com.barrientos.sistema_clinico.dto.MenuGrupoDto;
import com.barrientos.sistema_clinico.dto.MenuItemDto;
import com.barrientos.sistema_clinico.entity.MenuGroup;
import com.barrientos.sistema_clinico.entity.MenuItem;
import com.barrientos.sistema_clinico.repository.IMenuItemDao;
import com.barrientos.sistema_clinico.service.IMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuItemServiceImpl implements IMenuItemService {

    @Autowired
    private IMenuItemDao menuItemDao;

    @Override
    @Transactional(readOnly = true)
    public List<MenuItem> findAll() {
        return menuItemDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuItem> findMenuItemsByTipoUsuario(Long idTipoUsuario) {
        return menuItemDao.findMenuItemsByTipoUsuario(idTipoUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuGrupoDto> findMenuAgrupadoByTipoUsuario(Long idTipoUsuario) {

        List<MenuItem> items = menuItemDao.findMenuItemsByTipoUsuario(idTipoUsuario);

        Map<Long, MenuGrupoDto> grupos = new LinkedHashMap<>();

        for (MenuItem item : items) {

            MenuGroup grupo = item.getMenuGroup();

            MenuGrupoDto grupoDto = grupos.computeIfAbsent(
                    grupo.getId(),
                    id -> new MenuGrupoDto(
                            grupo.getId(),
                            grupo.getNombre(),
                            grupo.getIcono(),
                            grupo.getOrden(),
                            new ArrayList<>()
                    )
            );

            grupoDto.items().add(
                    new MenuItemDto(
                            item.getId(),
                            item.getNombre(),
                            item.getCategoria(),
                            item.getValor(),
                            item.getIcono(),
                            item.getOrden()
                    )
            );
        }

        return new ArrayList<>(grupos.values());
    }
}
