package com.spring.springtopicos20231.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springtopicos20231.entity.Trabalho;
import com.spring.springtopicos20231.exception.TrabalhoNaoEncontradoException;
import com.spring.springtopicos20231.repository.TrabalhoRepository;

@Service
public class TrabalhoService implements ITrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public Trabalho novoTrabalho(Trabalho trabalho) {
        if(trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }
        if(trabalho.getTitulo() == null) {
            throw new IllegalArgumentException("É necessário um titulo!");
        }
        if(trabalho.getGrupo() == null) {
            throw new IllegalArgumentException("É necessário um grupo!");
        }
        if(trabalho.getNota() == null) {
            trabalho.setNota(0);
        }
        return trabalhoRepo.save(trabalho);
    }

    public List<Trabalho> buscarTodosTrabalhos(){
        return trabalhoRepo.findAll();
    }
    
    public Trabalho buscarPorId(Long id) {
        Optional<Trabalho> trabalhoOp = trabalhoRepo.findById(id);
        if(trabalhoOp.isEmpty()) {
            throw new TrabalhoNaoEncontradoException("Trabalho não encontrado!");
        }
        return trabalhoOp.get();
    }
}
