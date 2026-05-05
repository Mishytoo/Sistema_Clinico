package com.barrientos.sistema_clinico.service;

import com.barrientos.sistema_clinico.entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonaService {
    public List<Persona> findAll(); //V1.1

    public Page<Persona> findAll(Pageable pageable);

    public void save(Persona persona);

    public Persona findOne(Long id);

    public void delete(Long id);

    public List<Persona> findByApellidoCompleto(String term);
}
