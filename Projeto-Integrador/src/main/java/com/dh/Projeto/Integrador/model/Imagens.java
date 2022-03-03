package com.dh.Projeto.Integrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity @Table
public class Imagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String Url;


    public Imagens(String titulo, String url) {
        this.titulo = titulo;
        Url = url;
    }
}
