package com.dh.Projeto.Integrador.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    @Column(unique=true)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    @ManyToOne(cascade = CascadeType.ALL)
    private Funcoes funcoes;

    public Usuarios(){

    }



}
