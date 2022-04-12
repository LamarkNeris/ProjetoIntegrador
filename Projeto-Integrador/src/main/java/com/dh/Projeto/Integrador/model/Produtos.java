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
    @OneToMany(cascade = CascadeType.ALL)
    private List<Imagens> imagens;
    @ManyToOne
    private Categorias categorias;
    @OneToOne
    private Caracteristicas caracteristicas;
    @ManyToOne
    private Cidades cidades;
    private double avaliacao;
    private Integer latitude;
    private Integer longitude;


    public Produtos(String nome, String descricao, List<Imagens> imagens, Categorias categorias, Caracteristicas caracteristicas,
                    Cidades cidades, double avaliacao, Integer latitude, Integer longitude) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagens = imagens;
        this.categorias = categorias;
        this.caracteristicas = caracteristicas;
        this.cidades = cidades;
        this.avaliacao = avaliacao;
        this.latitude = latitude;
        this.longitude = longitude;

    }
    public Produtos(){

    }
}
