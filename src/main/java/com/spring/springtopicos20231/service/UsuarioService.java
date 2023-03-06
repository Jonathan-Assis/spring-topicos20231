package com.spring.springtopicos20231.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springtopicos20231.entity.Usuario;
import com.spring.springtopicos20231.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public Usuario novoUsuario(Usuario usuario) {
        if(usuario == null 
                || usuario.getNome() == null 
                || usuario.getSenha() == null) {
            throw new IllegalArgumentException("Nome e senha inválidos!");
        }
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }
    
}