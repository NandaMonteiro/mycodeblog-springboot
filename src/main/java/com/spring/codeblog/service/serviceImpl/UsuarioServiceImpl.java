package com.spring.codeblog.service.serviceImpl;

import com.spring.codeblog.model.Usuario;
import com.spring.codeblog.repository.UsuarioRepository;
import com.spring.codeblog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(String.valueOf(id)).get();
    }

    @Override
    public List<Usuario> usuarioList() {
        return usuarioRepository.findAll();
    }

    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }
}
