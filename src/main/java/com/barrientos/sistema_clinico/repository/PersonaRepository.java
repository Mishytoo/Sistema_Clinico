package com.barrientos.sistema_clinico.repository;

import com.barrientos.sistema_clinico.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
