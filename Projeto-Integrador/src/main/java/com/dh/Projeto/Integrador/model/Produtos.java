package com.dh.Projeto.Integrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity @Table
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    @OneToMany
    private List<Imagens> imagens;
    @ManyToOne
    private Categorias categorias;
    @ManyToMany
    private List<Caracteristicas> caracteristicas;
    @ManyToOne
    private Cidades cidades;


    public Produtos(String nome, String descricao, List<Imagens> imagens, Categorias categorias, List<Caracteristicas> caracteristicas, Cidades cidades) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagens = imagens;
        this.categorias = categorias;
        this.caracteristicas = caracteristicas;
        this.cidades = cidades;

    }
    public Produtos(){

    }
}
