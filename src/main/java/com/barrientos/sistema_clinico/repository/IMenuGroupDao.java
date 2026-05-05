package com.barrientos.sistema_clinico.repository;

import com.barrientos.sistema_clinico.entity.MenuGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuGroupDao extends JpaRepository<MenuGroup, Long> {}