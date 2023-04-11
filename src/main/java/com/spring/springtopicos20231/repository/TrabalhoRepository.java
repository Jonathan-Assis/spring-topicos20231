package com.spring.springtopicos20231.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.springtopicos20231.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
    
    public List<Trabalho> findByTituloContains(String texto);

    @Query("select t from Trabalho t where t.titulo like %?1%")
    public List<Trabalho> buscarPorTitulo(String texto);
}
