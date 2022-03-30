package com.dh.Projeto.Integrador.DTO;

import com.dh.Projeto.Integrador.model.Usuarios;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Getter @Setter
public class UserAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;

    public UserAdmin(String userName, String password) {
        this.username = userName;
        this.password = password;
    }
    public UserAdmin(){

    }
}
