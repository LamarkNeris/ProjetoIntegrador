package com.dh.Projeto.Integrador.service;

import com.dh.Projeto.Integrador.model.Usuarios;
import com.dh.Projeto.Integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository adminrepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuarios usuario = adminrepository.findByEmail(email);

        List<GrantedAuthority> authoritiesListUser = List.of(new SimpleGrantedAuthority("ADMIN"));

//        Set<GrantedAuthority> grantList = new HashSet<>();
//        grantList.add(new SimpleGrantedAuthority("ADMIN"));
//
//        UserDetails user = new User(usuario.getEmail(),("{noop}" + usuario.getSenha()), grantList );

        return new User(usuario.getEmail(), usuario.getSenha(), authoritiesListUser);
    }

}
