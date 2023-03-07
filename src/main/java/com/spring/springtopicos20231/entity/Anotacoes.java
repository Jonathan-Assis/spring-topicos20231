package com.spring.springtopicos20231.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ant_anotacoes")
public class Anotacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ant_id")
    private Long id;

    @Column(name = "ant_anotacao")
    private String anotacao;

    @Column(name = "ant_data_atualizado")
    private String dataAtualizado;

    public Anotacoes(String anotacao, String dataAtualizado) {
        this.anotacao = anotacao;
        this.dataAtualizado = dataAtualizado;
    }

    public Anotacoes() {
        // Do Nothing
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public String getDataAtualizado() {
        return dataAtualizado;
    }

    public void setDataAtualizado(String dataAtualizado) {
        this.dataAtualizado = dataAtualizado;
    }
    
}