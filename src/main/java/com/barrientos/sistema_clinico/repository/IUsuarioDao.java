package com.barrientos.sistema_clinico.repository;

import com.barrientos.sistema_clinico.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {

    @Query("""
           select u from Usuario u
           join fetch u.tipoUsuario
           join fetch u.persona
           where u.nomUsuario = :nomUsuario
           """)
    Optional<Usuario> findByNomUsuario(@Param("nomUsuario") String nomUsuario);

}