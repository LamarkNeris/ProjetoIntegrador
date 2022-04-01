package com.dh.Projeto.Integrador.service;

import com.dh.Projeto.Integrador.model.UserAdmin;
import com.dh.Projeto.Integrador.repository.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAdminRepository adminrepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserAdmin usuario = adminrepository.findByEmail(email);

         List<GrantedAuthority> authoritiesListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authoritiesListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

//        Set<GrantedAuthority> grantList = new HashSet<>();
//        grantList.add(new SimpleGrantedAuthority("ADMIN"));
//
//        UserDetails user = new User(usuario.getEmail(),("{noop}" + usuario.getSenha()), grantList );

        return new User(usuario.getEmail(), usuario.getSenha(),
                usuario.isAdmin() ? authoritiesListAdmin : authoritiesListUser);
    }

}
