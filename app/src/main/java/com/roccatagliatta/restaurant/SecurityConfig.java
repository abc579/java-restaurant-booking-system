package com.roccatagliatta.restaurant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF because we use JWT.
        http
            .authorizeHttpRequests((requests) -> requests
                                   .requestMatchers("/user/signup").permitAll()
                                   .anyRequest().authenticated()
                                   )
            .csrf((csrf) -> csrf.disable());

        return http.build();
    }
}
