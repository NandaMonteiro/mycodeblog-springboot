package com.spring.codeblog.service;

import com.spring.codeblog.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario saveUsuario(Usuario usuario);
    Usuario findById(Long id);
    List<Usuario> usuarioList();
}
