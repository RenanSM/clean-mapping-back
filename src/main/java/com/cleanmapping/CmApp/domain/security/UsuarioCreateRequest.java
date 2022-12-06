/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cleanmapping.CmApp.domain.security;

import lombok.Data;

/**
 *
 * @author Devsys-B
 */


@Data
public class UsuarioCreateRequest {

    private String username;
    private String password;
    
}
