package com.dh.Projeto.Integrador.config;

import com.dh.Projeto.Integrador.model.UserAdmin;
import com.dh.Projeto.Integrador.model.Usuarios;
import com.dh.Projeto.Integrador.repository.UserAdminRepository;
import com.dh.Projeto.Integrador.repository.UsuarioRepository;
import com.dh.Projeto.Integrador.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfi extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/usuario/").permitAll()
                .antMatchers(HttpMethod.GET,"/usuario/").permitAll()
//                .antMatchers(HttpMethod.PUT,"/produto/","/categoria/","/cidade/","/usuario/").permitAll()
//                .antMatchers(HttpMethod.DELETE,"/produto/","/categoria/","/cidade/","/usuario/").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();


        }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
