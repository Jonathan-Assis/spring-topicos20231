package com.spring.springtopicos20231.service;

import java.util.List;

import com.spring.springtopicos20231.entity.Usuario;

public interface IUsuarioService {

    public Usuario novoUsuario(Usuario usuario);

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarPorId(Long id);

    public Usuario adicionarAutorizacao(Long idUsuario, Long idAutorizacao);

}