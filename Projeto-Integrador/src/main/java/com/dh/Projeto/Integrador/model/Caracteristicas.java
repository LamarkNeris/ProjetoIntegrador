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
    private boolean piscina;
    private boolean restaurante;
    private boolean cafe_da_manha;
    private boolean estacionamento;
    private boolean permite_animais;
    private boolean hidromassagem;
    private boolean quartos_familia;
    private boolean area_fumantes;
    private boolean bar;
    private boolean churrasqueira;
    private boolean lavanderia;


    public Caracteristicas(boolean wifi, boolean ar_condicionado, boolean tv_a_cabo, boolean piscina,
                           boolean restaurante, boolean cafe_da_manha, boolean estacionamento, boolean permite_animais,
                           boolean hidromassagem, boolean quartos_familia, boolean area_fumantes, boolean bar, boolean churrasqueira,
                           boolean lavanderia) {
        this.wifi = wifi;
        this.ar_condicionado = ar_condicionado;
        this.tv_a_cabo = tv_a_cabo;
        this.piscina = piscina;
        this.restaurante = restaurante;
        this.cafe_da_manha = cafe_da_manha;
        this.estacionamento = estacionamento;
        this.permite_animais = permite_animais;
        this.hidromassagem = hidromassagem;
        this.quartos_familia = quartos_familia;
        this.area_fumantes = area_fumantes;
        this.bar = bar;
        this.churrasqueira = churrasqueira;
        this.lavanderia = lavanderia;
    }

    public Caracteristicas(){

    }
}