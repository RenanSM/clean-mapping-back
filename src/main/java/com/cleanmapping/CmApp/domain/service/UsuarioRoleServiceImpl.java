/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cleanmapping.CmApp.domain.service;

import com.cleanmapping.CmApp.domain.model.Role;
import com.cleanmapping.CmApp.domain.model.Usuario;
import com.cleanmapping.CmApp.domain.repository.RoleRepository;
import com.cleanmapping.CmApp.domain.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author REN
 */

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UsuarioRoleServiceImpl implements UsuarioRoleService, UserDetailsService {

    
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
        
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario == null){
            log.error("Não foi possível encontrar esse usuário em nosso banco de dados");
        } else{
            log.info("Usuário: {}, encontrado", username);
        }
        
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(role -> 
        { 
            authorities.add(new SimpleGrantedAuthority(role.getName())); 
        });
                
        
        
        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), authorities);
    }
    
    
    
    
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        log.info("Novo usuário {} salvo na database", usuario.getName());
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Nova role {} salva na database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adicionando role {} para o usuario {}", roleName, username );
       Usuario usuario  = usuarioRepository.findByUsername(username);
       Role role = roleRepository.findByName(roleName);
       usuario.getRoles().add(role);
    }

    @Override
    public Usuario getUsuario(String username) {
        log.info("Buscando usuário {}", username);
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public List<Usuario> getUsuario() {
        log.info("Buscando todos usuários {}");
        return usuarioRepository.findAll();
    }
    

    
}
