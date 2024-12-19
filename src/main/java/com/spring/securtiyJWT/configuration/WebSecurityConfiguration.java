package com.spring.securtiyJWT.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

    @Autowired
    private JwtAythenticationEntryPoint jwtAythenticationEntryPoint;


    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(auth ->
                       auth.requestMatchers("/").permitAll()
                               .requestMatchers(HttpHeaders.ALLOW).permitAll()
                               .anyRequest().authenticated())
               .exceptionHandling(exceptionHandling ->exceptionHandling.authenticationEntryPoint(jwtAythenticationEntryPoint) )
               .sessionManagement(sessionmanagement->sessionmanagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


       return httpSecurity.build();

    }
}
