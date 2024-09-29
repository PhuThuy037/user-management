package com.user.User_Management.config;

import com.user.User_Management.service.OurUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private OurUserDetailsService userDetailsService;
    @Autowired
    private JWTAuthFilter jwtAuthFilter;


}
