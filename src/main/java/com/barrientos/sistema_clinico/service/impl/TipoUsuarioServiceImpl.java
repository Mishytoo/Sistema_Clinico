package com.barrientos.sistema_clinico.service.impl;

import com.barrientos.sistema_clinico.entity.TipoUsuario;
import com.barrientos.sistema_clinico.repository.ITipoUsuarioDao;
import com.barrientos.sistema_clinico.service.ITipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements ITipoUsuarioService {

    @Autowired
    private ITipoUsuarioDao tipoUsuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<TipoUsuario> findAll() {
        return (List<TipoUsuario>) tipoUsuarioDao.findAll();
    }

}
