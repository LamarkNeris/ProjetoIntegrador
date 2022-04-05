package com.dh.Projeto.Integrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date checkIn;
    @Temporal(TemporalType.DATE)
    private Date checkOut;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produtos produto;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;
    private LocalTime registroHora;

    public Reservas(Date checkIn, Date checkOut, Produtos produto, Usuarios usuario, LocalTime registroHora) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.produto = produto;
        this.usuario = usuario;
        this.registroHora = registroHora;
    }


    public Reservas() {
    }

}
