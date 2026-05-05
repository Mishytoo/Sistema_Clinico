package com.barrientos.sistema_clinico.repository;

import com.barrientos.sistema_clinico.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//public interface IPersonaDao { //V1.0
//public interface IPersonaDao extends CrudRepository<Persona, Long> {//V1.1
    /*public List<Persona> findAll();
    public void save(Persona persona);
    public Persona findOne(Long id);
    public void delete(Long id);*/ //V1.0

//public interface IPersonaDao extends CrudRepository<Persona, Long>, PagingAndSortingRepository<Persona, Long> {//V1.2
public interface IPersonaDao extends JpaRepository<Persona, Long> { //V1.3
//    @Query("select p from Persona p where p.apellidoCompleto like %?1%")
//    public List<Persona> findByApellidoCompleto(String term);
    public List<Persona> findByApellidoCompletoContainingIgnoreCase(String term);

}
