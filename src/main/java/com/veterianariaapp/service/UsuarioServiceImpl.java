package com.veterianariaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.veterianariaapp.model.Usuario;
import com.veterianariaapp.repository.UsuarioRepository;
import com.veterianariaapp.service.interfaces.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

}
