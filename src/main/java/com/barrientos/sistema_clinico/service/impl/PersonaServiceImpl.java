package com.barrientos.sistema_clinico.service.impl;

import com.barrientos.sistema_clinico.entity.Persona;
import com.barrientos.sistema_clinico.repository.IPersonaDao;
import com.barrientos.sistema_clinico.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        //return personaDao.findAll();//v1.0
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findOne(Long id) {
        //return personaDao.findOne(id);//v1.0
        return personaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Persona> findAll(Pageable pageable) {
        return personaDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        //personaDao.delete(id);//v1.0
        personaDao.deleteById(id);
    }

    @Override
    public List<Persona> findByApellidoCompleto(String term) {
        //return personaDao.findByApellidoCompleto(term);
        return personaDao.findByApellidoCompletoContainingIgnoreCase(term);
    }
}
