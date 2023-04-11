package com.spring.springtopicos20231.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springtopicos20231.entity.Trabalho;
import com.spring.springtopicos20231.service.ITrabalhoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/trabalho")
public class TrabalhoController {
    
    @Autowired
    private ITrabalhoService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Trabalho novoTrabalho(@RequestBody Trabalho trabalho) {
        return service.novoTrabalho(trabalho);
    }

    @GetMapping
    public List<Trabalho> buscarTodosTrabalhos(){
        return service.buscarTodosTrabalhos();
    } 

    @GetMapping(value = "/id/{trabalho}")
    public Trabalho buscarPorId(@PathVariable("trabalho") Long id) {
        return service.buscarPorId(id);
    }

}
