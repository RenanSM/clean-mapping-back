/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cleanmapping.CmApp.domain.service;

import com.cleanmapping.CmApp.domain.model.Role;
import com.cleanmapping.CmApp.domain.model.Usuario;

import java.util.List;

/**
 *
 * @author REN
 */
public interface UsuarioRoleService {
    
    Usuario saveUsuario(Usuario usuario);
    Role saveRole(Role role);
    
    //Metodo para adicionar uma Role para um usuário
    void addRoleToUser(String username, String roleName);
    
    Usuario getUsuario(String username);
    
    List<Usuario>getUsuario();           
    
}
