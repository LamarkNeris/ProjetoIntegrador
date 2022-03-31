package com.dh.Projeto.Integrador.controller;

import com.dh.Projeto.Integrador.DTO.UsuarioSenha;
import com.dh.Projeto.Integrador.model.Usuarios;
import com.dh.Projeto.Integrador.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Usuarios> create(@RequestBody Usuarios usuarios){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        usuarios.setSenha(encoder.encode(usuarios.getSenha()));
        usuarioService.createUser(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<Usuarios>> selectall(){
        return ResponseEntity.ok(usuarioService.AllUsers());
    }

    @PostMapping("/jwt")
    public ResponseEntity<String> getJwt(@RequestBody UsuarioSenha usuarios){
        Usuarios usuario = usuarioService.checkUser(usuarios);

        if (usuario != null){

            String KEY = "chave_Jwt";
            Long timer = System.currentTimeMillis();
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, KEY)
                    .setSubject(usuario.getEmail())
                    .setIssuedAt(new Date(timer))
                    .setExpiration(new Date(timer + 900000))
                    .claim(KEY, usuario)
                    .compact();

            return ResponseEntity.ok(jwt);

        }
        return ResponseEntity.ok("Usuario não existe!");
    }

}
