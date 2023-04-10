package com.spring.springtopicos20231.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springtopicos20231.entity.Autorizacao;
import com.spring.springtopicos20231.entity.Usuario;
import com.spring.springtopicos20231.exception.UsuarioNaoEncontradoException;
import com.spring.springtopicos20231.repository.AutorizacaoRepository;
import com.spring.springtopicos20231.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autRepo;

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

    public Usuario adicionarAutorizacao(Long idUsuario, Long idAutorizacao) {
        Optional<Autorizacao> autOp = autRepo.findById(idAutorizacao);
        if(autOp.isEmpty()) {
            throw new IllegalArgumentException("Id da autorização inválido!");
        }
        Optional<Usuario> usuarioOp = usuarioRepo.findById(idUsuario);
        if(usuarioOp.isEmpty()) {
            throw new IllegalArgumentException("Id do usuário inválido!");
        }
        Usuario usuario = usuarioOp.get();
        usuario.setAutorizacoes(new ArrayList<Autorizacao>());
        usuario.getAutorizacoes().add(autOp.get());
        return usuarioRepo.save(usuario);
    }
    
    
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuário não existe!");
        }
        return usuarioOp.get();
    }
}