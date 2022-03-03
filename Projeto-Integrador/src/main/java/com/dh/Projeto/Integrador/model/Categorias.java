package com.dh.Projeto.Integrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table
@Getter
@Setter
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descricao;
    private String url_Img;


    public Categorias(String titulo, String descricao, String url_Img) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url_Img = url_Img;
    }

    public Categorias(){

    }
}
