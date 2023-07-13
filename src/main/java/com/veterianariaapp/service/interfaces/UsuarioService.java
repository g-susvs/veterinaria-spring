package com.veterianariaapp.service.interfaces;

import java.util.List;

import com.veterianariaapp.model.Usuario;

public interface UsuarioService {
    List<Usuario> getUsuarios();

    Usuario saveUsuario(Usuario usuario);
}
