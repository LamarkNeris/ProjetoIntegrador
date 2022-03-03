package com.dh.Projeto.Integrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table
@Getter
@Setter
public class Caracteristicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String icone;

    public Caracteristicas(String nome, String icone) {
        this.nome = nome;
        this.icone = icone;

    }
}
