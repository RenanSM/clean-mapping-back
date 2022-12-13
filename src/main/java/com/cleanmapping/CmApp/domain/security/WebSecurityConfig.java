/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
package com.cleanmapping.CmApp.domain.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/usuario/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
               
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new MessageDigestPasswordEncoder("MD5");
    }
    


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        
        auth.inMemoryAuthentication()
            .passwordEncoder(new MessageDigestPasswordEncoder("MD5"))
                .withUser("kaylane")
                .password(passwordEncoder().encode("737"))
                .roles("ADMIN")
            .and()
                .withUser("reader")
                .password(passwordEncoder().encode("reader1"))
                .roles("USER")
        ;
    }
    
}