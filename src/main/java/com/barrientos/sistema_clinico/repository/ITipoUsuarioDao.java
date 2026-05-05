package com.barrientos.sistema_clinico.repository;

import com.barrientos.sistema_clinico.entity.TipoUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITipoUsuarioDao extends CrudRepository<TipoUsuario, Long>, PagingAndSortingRepository<TipoUsuario, Long> {}