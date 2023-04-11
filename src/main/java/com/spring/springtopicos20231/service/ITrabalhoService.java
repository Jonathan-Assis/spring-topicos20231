package com.spring.springtopicos20231.service;

import java.util.List;

import com.spring.springtopicos20231.entity.Trabalho;

public interface ITrabalhoService {
    
    public Trabalho novoTrabalho(Trabalho trabalho);

    public List<Trabalho> buscarTodosTrabalhos();

    public Trabalho buscarPorId(Long id);
}
