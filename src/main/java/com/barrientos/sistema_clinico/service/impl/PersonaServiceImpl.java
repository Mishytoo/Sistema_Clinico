package com.barrientos.sistema_clinico.service.impl;

import com.barrientos.sistema_clinico.entity.Persona;
import com.barrientos.sistema_clinico.repository.PersonaRepository;
import com.barrientos.sistema_clinico.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public List<Persona> obtenerPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona obtenerPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        Persona personaBBDD = personaRepository.findById(id).orElse(null);

        if(personaBBDD != null)
        {
            personaBBDD.setTipoDocumento(persona.getTipoDocumento());
            personaBBDD.setNroDocumento(persona.getNroDocumento());
            personaBBDD.setNombreCompleto(persona.getNombreCompleto());
            personaBBDD.setApellidoCompleto(persona.getApellidoCompleto());
            personaBBDD.setSexo(persona.getSexo());
            personaBBDD.setCelular(persona.getCelular());
            personaBBDD.setFechaNacimiento(persona.getFechaNacimiento());
            personaBBDD.setDireccion(persona.getDireccion());
            personaRepository.save(personaBBDD);
        }
        return  null;
    }

    @Override
    public void eliminarPersona(Long id) {

        personaRepository.deleteById(id);

    }

    @Override
    public long contarPersonas() {
        return personaRepository.count();
    }
}
