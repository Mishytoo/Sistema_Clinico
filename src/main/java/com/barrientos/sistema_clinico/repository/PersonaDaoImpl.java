/*package com.barrientos.sistema_clinico.models.dao;

import com.barrientos.sistema_clinico.entity.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Obsoleto_PersonaDaoImpl implements IPersonaDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Persona> findAll() {
        return em.createQuery("from Persona", Persona.class).getResultList();
    }

    @Override
    public Persona findOne(Long id) {
        return em.find(Persona.class, id);
    }


    @Override
    public void save(Persona persona) {
        if(persona.getId() != null && persona.getId() > 0){
            em.merge(persona);
        }else{
            em.persist(persona);
        }
    }

    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
*/