package com.barrientos.sistema_clinico.repository;

import com.barrientos.sistema_clinico.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMenuItemDao extends JpaRepository<MenuItem, Long> {

    @Query("""
       select mi from MenuItem mi
       join fetch mi.menuGroup mg
       join mi.acceso tu
       where tu.tipoUsuario.id = :idTipoUsuario
       and mi.estado = 1
       and mg.estado = 1
       order by mg.orden asc, mi.orden asc
       """)
    List<MenuItem> findMenuItemsByTipoUsuario(@Param("idTipoUsuario") Long idTipoUsuario);
}