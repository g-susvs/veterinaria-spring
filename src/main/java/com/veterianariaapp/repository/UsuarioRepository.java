package com.veterianariaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterianariaapp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);

    List<Usuario> findByFechaRegistroNotNull();
}
