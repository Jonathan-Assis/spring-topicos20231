package com.spring.springtopicos20231.service;

import java.util.List;

import com.spring.springtopicos20231.entity.Anotacao;

public interface IAnotacaoService {
    
    public Anotacao novaAnotacao(Anotacao anotacao);

    public List<Anotacao> buscarTodas();
}
