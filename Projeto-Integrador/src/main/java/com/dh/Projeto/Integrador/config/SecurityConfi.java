package com.dh.Projeto.Integrador.config;

import com.dh.Projeto.Integrador.model.Usuarios;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfi extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/produto/","/categoria/","/cidade/","/usuario/").permitAll()
                .antMatchers(HttpMethod.GET,"/produto/","/categoria/","/cidade/","/usuario/").permitAll()
                .antMatchers(HttpMethod.PUT,"/produto/","/categoria/","/cidade/","/usuario/").permitAll()
                .antMatchers(HttpMethod.DELETE,"/produto/","/categoria/","/cidade/","/usuario/").permitAll()
                .anyRequest().permitAll()
                .and()
                .httpBasic();


    }

}
