package com.dh.Projeto.Integrador.service;

import com.dh.Projeto.Integrador.DTO.UserAdmin;
import com.dh.Projeto.Integrador.model.Usuarios;
import com.dh.Projeto.Integrador.repository.UserAdminRepository;
import com.dh.Projeto.Integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAdminRepository adminrepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserAdmin usuario = adminrepository.findByUsername(username);

        Set<GrantedAuthority> grantList = new HashSet<>();
        grantList.add(new SimpleGrantedAuthority("USER"));

        UserDetails user = new User(usuario.getUsername(),("{noop}" + usuario.getPassword()), grantList );

        return user;
    }

}
