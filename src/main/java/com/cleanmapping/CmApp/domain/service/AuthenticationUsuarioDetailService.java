/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cleanmapping.CmApp.domain.service;

import com.cleanmapping.CmApp.domain.model.Usuario;
import java.util.Arrays;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationUsuarioDetailService implements UserDetailsService {
    
        private final UsuarioService usuarioService;
        
       public UserDetails loadUsuarioByUsername(String username) throws UsernameNotFoundException{
            Usuario usuario = usuarioService.readUsuarioByUsername(username);
            if(usuario == null){
            throw new UsernameNotFoundException(username); 
            }
            return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), getAuthorities(usuario.getRole()));
        }
    
        private Collection<? extends GrantedAuthority> getAuthorities(String role){
            return Arrays.asList(new SimpleGrantedAuthority(role));
        }
       

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
