package com.cleanmapping.CmApp;

import com.cleanmapping.CmApp.domain.model.Role;
import com.cleanmapping.CmApp.domain.model.Usuario;
import com.cleanmapping.CmApp.domain.service.UsuarioRoleService;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
//@ComponentScan(basePackages= {"com.cleanmapping.CmApp.Api.controller"})
public class CmAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmAppApplication.class, args);
	}
        
        @Bean
        PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
        
        
        
        
        
        /*
        @Bean
        CommandLineRunner run(UsuarioRoleService usuarioRoleService){
            return args -> {
                
                usuarioRoleService.saveRole(new Role(null, "ROLE_USER"));
                usuarioRoleService.saveRole(new Role(null, "ROLE_MANAGER"));
                usuarioRoleService.saveRole(new Role(null, "ROLE_ADMIN"));
                usuarioRoleService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
                
                
                usuarioRoleService.saveUsuario(new Usuario("Renan", "renanzin", "14577855644", "123", "ATIVO", new ArrayList<>()));
                usuarioRoleService.saveUsuario(new Usuario("Juan", "juanmars", "14572855644", "123", "ATIVO", new ArrayList<>()));
                usuarioRoleService.saveUsuario(new Usuario("Joao", "joaozin", "12577855644", "123", "ATIVO", new ArrayList<>()));
                usuarioRoleService.saveUsuario(new Usuario("Kleber", "kge", "14577457644", "123", "ATIVO", new ArrayList<>()));
                
                
                usuarioRoleService.addRoleToUser("renren", "ROLE_SUPER_ADMIN");
                usuarioRoleService.addRoleToUser("renren", "ROLE_MANAGER");
                usuarioRoleService.addRoleToUser("renren", "ROLE_USER");
                usuarioRoleService.addRoleToUser("kge", "ROLE_MANAGER");
                usuarioRoleService.addRoleToUser("joaozin", "ROLE_ADMIN");
                usuarioRoleService.addRoleToUser("juanmars", "ROLE_USER");

                
            };
        
        }*/
        
}
