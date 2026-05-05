package com.barrientos.sistema_clinico.service.impl;

import com.barrientos.sistema_clinico.entity.Usuario;
import com.barrientos.sistema_clinico.repository.IUsuarioDao;
import com.barrientos.sistema_clinico.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findOne(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        //usuarioDao.save(usuario);

        if (usuario.getId() == null) { //crear
            usuario.setClaveUsuario(passwordEncoder.encode(usuario.getClaveUsuario()));
        } else { //editar
            Usuario usuarioDb = usuarioDao.findById(usuario.getId()).orElse(null);
            if (usuarioDb != null) {
                if (usuario.getClaveUsuario() == null || usuario.getClaveUsuario().isBlank()) {
                    usuario.setClaveUsuario(usuarioDb.getClaveUsuario());
                } else if (!isBCrypt(usuario.getClaveUsuario())) { //clave sin descodificar
                    usuario.setClaveUsuario(passwordEncoder.encode(usuario.getClaveUsuario()));
                }
            }
        }

        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findByNomUsuario(String username) {
        return usuarioDao.findByNomUsuario(username);
    }

    private boolean isBCrypt(String clave) {
        return clave != null && clave.matches("^\\$2[aby]\\$\\d{2}\\$.{53}$");
    }
}
