package com.sazke.springcloud.msvcusuarios.repositories;

import com.sazke.springcloud.msvcusuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {


    Optional<Usuario> findByEmail(String email);
}
