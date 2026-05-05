package com.barrientos.sistema_clinico.repository;

import com.barrientos.sistema_clinico.entity.Acceso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccesoDao extends JpaRepository<Acceso, Long> {}