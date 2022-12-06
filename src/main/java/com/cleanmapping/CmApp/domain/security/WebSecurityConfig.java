/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/*
https://www.javatodev.com/spring-boot-jwt-authentication/
*/
package com.cleanmapping.CmApp.domain.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class WebSecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new MessageDigestPasswordEncoder("MD5");
    }
    
    
    
    
}