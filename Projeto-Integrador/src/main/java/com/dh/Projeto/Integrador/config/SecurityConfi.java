package com.dh.Projeto.Integrador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfi extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/produto/**","/categoria/**","/cidade/**","/usuario/**").permitAll()
                .antMatchers(HttpMethod.GET,"/produto/**","/categoria/**","/cidade/**","/usuario/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/produto/**","/categoria/**","/cidade/**","/usuario/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/produto/**","/categoria/**","/cidade/**","/usuario/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;

    }


}
