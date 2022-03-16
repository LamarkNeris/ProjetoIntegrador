package com.dh.Projeto.Integrador.controller;

import com.dh.Projeto.Integrador.model.Usuarios;
import com.dh.Projeto.Integrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioService usuarioService, PasswordEncoder encoder) {
        this.usuarioService = usuarioService;
        this.encoder = encoder;
    }


    @PostMapping
    public ResponseEntity<Usuarios> create(@RequestBody Usuarios usuarios){
        usuarios.setSenha(encoder.encode(usuarios.getSenha()));
        usuarioService.createUser(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
