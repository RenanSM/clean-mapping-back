/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cleanmapping.CmApp.domain.security.config;

import com.cleanmapping.CmApp.domain.security.JWTAuthenticationFilter;
import com.cleanmapping.CmApp.domain.security.JWTAuthorizationFilter;
import com.cleanmapping.CmApp.domain.service.AuthenticationUsuarioDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationUsuarioDetailService authenticationUsuarioDetailService;
    
       
    @Override protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
                .antMatchers("/**").hasAnyAuthority("ADMIN")
                            .antMatchers("/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                    
        
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUsuarioDetailService).passwordEncoder(passwordEncoder);
    }
    
}
