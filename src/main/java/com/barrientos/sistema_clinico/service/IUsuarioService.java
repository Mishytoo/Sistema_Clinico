package com.barrientos.sistema_clinico.service;

import com.barrientos.sistema_clinico.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> findAll(); //V1.1

    public Page<Usuario> findAll(Pageable pageable);

    public void save(Usuario usuario);

    public Usuario findOne(Long id);

    public void delete(Long id);

    Optional<Usuario> findByNomUsuario(String username);
}
