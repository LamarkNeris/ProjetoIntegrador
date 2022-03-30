package com.dh.Projeto.Integrador.service;

import com.dh.Projeto.Integrador.model.Usuarios;
import com.dh.Projeto.Integrador.repository.UserAdminRepository;
import com.dh.Projeto.Integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuarios createUser(Usuarios usuarios){

//        Usuarios usuario = new Usuarios(usuarios.getNome(), usuarios.getSobrenome(), usuarios.getEmail(),
//                usuarios.getSenha(), usuarios.getFuncoes());
        return usuarioRepository.save(usuarios);
    }

    public List<Usuarios> AllUsers(){
        return usuarioRepository.findAll();
    }

    public Usuarios checkUser(Usuarios usuario){
        Usuarios user = usuarioRepository.findByEmail(usuario.getEmail());

        return user;
    }

}
