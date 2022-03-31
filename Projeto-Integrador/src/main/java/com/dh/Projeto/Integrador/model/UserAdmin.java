package com.dh.Projeto.Integrador.model;

import com.dh.Projeto.Integrador.model.Usuarios;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Table(name = "email", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
@Entity
@Getter @Setter
public class UserAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;


    public UserAdmin(){

    }
}
