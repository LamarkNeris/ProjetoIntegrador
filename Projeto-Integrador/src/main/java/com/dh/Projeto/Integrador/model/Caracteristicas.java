package com.dh.Projeto.Integrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table
@Getter
@Setter
public class Caracteristicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean wifi;
    private boolean ar_condicionado;
    private boolean tv_a_cabo;


    public Caracteristicas( boolean wifi, boolean ar_condicionado, boolean tv_a_cabo) {
        this.wifi = wifi;
        this.ar_condicionado = ar_condicionado;
        this.tv_a_cabo = tv_a_cabo;
    }

    public Caracteristicas(){

    }
}