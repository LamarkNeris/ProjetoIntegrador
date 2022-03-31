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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfi extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/usuario/**").permitAll()
                .antMatchers(HttpMethod.GET,"/produto/","/categoria/","/cidade/","/usuario/").permitAll()
                .antMatchers(HttpMethod.PUT,"/produto/","/categoria/","/cidade/","/usuario/").permitAll()
                .antMatchers(HttpMethod.DELETE,"/produto/","/categoria/","/cidade/","/usuario/").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();


        }

    @Autowired
    public void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("senha").roles("USER")
                .and()
                .withUser("admin").password("senha").roles("USER", "ADMIN");

    }

}
