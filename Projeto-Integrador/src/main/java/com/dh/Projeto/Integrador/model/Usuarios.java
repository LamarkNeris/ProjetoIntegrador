package com.dh.Projeto.Integrador.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
public class Usuarios extends UserAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    @ManyToOne(cascade = CascadeType.ALL)
    private Funcoes funcoes;


    public Usuarios(String nome, String sobrenome, Funcoes funcoes) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.funcoes = funcoes;
    }

    public Usuarios(){

    }



}
