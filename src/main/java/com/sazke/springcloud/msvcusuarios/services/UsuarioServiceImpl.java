package com.sazke.springcloud.msvcusuarios.services;

import com.sazke.springcloud.msvcusuarios.client.CursoClienteRest;
import com.sazke.springcloud.msvcusuarios.models.entity.Usuario;
import com.sazke.springcloud.msvcusuarios.repositories.UsuarioRepository;
import com.sazke.springcloud.msvcusuarios.services.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoClienteRest client;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {

        usuarioRepository.delete(usuario);
        client.eliminarCursoUsuarioById(usuario.getId());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
        client.eliminarCursoUsuarioById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAllById(Iterable<Long> listIds) {
        return (List<Usuario>) usuarioRepository.findAllById(listIds);

    }


}
