package com.sazke.springcloud.msvcusuarios.services.interfaces;

import com.sazke.springcloud.msvcusuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario>findAll();
    Optional<Usuario>findById(Long id);
    Usuario save(Usuario usuario);
    void delete(Usuario usuario);
    void deleteById(Long id);
    Optional<Usuario> findByEmail(String email);
    List<Usuario>findAllById(Iterable<Long> listIds);
}
