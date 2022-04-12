package com.dh.Projeto.Integrador.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class ReservaDto {

    private Integer id;
    private Date checkIn;
    private Date checkOut;
    private Integer produtoId;
    private Integer usuarioId;
    private String horaCheckIn;



}
