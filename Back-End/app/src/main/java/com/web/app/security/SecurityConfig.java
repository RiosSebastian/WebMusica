package com.web.app.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll()  // Permite todas las solicitudes sin autenticación
                )
                .csrf(AbstractHttpConfigurer::disable)  // Desactiva CSRF para API REST
                .formLogin(AbstractHttpConfigurer::disable)  // Desactiva el formulario de login
                .httpBasic(AbstractHttpConfigurer::disable);  // Desactiva la autenticación básica

        return http.build();
    }
}