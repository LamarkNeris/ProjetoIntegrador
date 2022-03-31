package com.dh.Projeto.Integrador.service;

import com.dh.Projeto.Integrador.DTO.UsuarioSenha;
import com.dh.Projeto.Integrador.model.UserAdmin;
import com.dh.Projeto.Integrador.model.Usuarios;
import com.dh.Projeto.Integrador.repository.UserAdminRepository;
import com.dh.Projeto.Integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuarios createUser(Usuarios usuarios) {

//        Usuarios usuario = new Usuarios(usuarios.getNome(), usuarios.getSobrenome(), usuarios.getEmail(),
//                usuarios.getSenha(), usuarios.getFuncoes());
        return usuarioRepository.save(usuarios);
    }

    public List<Usuarios> AllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuarios checkUser(UsuarioSenha usuario) {
        Usuarios user = usuarioRepository.findByEmail(usuario.getEmail());

        if(user == null) {

            throw new RuntimeException("usuario nulo");
        }
        if (new BCryptPasswordEncoder().matches(user.getSenha(), usuario.getSenha())) {

            throw new RuntimeException("senha incorreta");

        }

        return user;
    }
}
