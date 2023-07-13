package com.veterianariaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterianariaapp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
