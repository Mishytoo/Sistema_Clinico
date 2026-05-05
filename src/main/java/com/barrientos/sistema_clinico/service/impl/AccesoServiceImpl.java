package com.barrientos.sistema_clinico.service.impl;

import com.barrientos.sistema_clinico.entity.Acceso;
import com.barrientos.sistema_clinico.repository.IAccesoDao;
import com.barrientos.sistema_clinico.service.IAccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccesoServiceImpl implements IAccesoService {

    @Autowired
    private IAccesoDao accesoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Acceso> findAll() {
        return accesoDao.findAll();
    }

}
