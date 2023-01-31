/**
* FastFood API
* API básica para melhoria e implementação.
*
* Endpoint: Usuario
*/
package com.cleanmapping.CmApp.Api.controller;


import com.cleanmapping.CmApp.domain.model.Role;
import com.cleanmapping.CmApp.domain.model.Usuario;
import com.cleanmapping.CmApp.domain.repository.UsuarioRepository;
import com.cleanmapping.CmApp.domain.service.UsuarioRoleService;
import com.cleanmapping.CmApp.domain.service.UsuarioService;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



/**
* Implementa RestController de Usuario
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@RestController @RequiredArgsConstructor
@RequestMapping("/client")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioService usuarioService;
    
    private final UsuarioRoleService usuarioRoleService;
    

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>>getUsuario(){
        return ResponseEntity.ok().body(usuarioRoleService.getUsuario());
    }
    
    @PostMapping("/usuario/save")
    public ResponseEntity<Usuario>saveUsuario(@RequestBody Usuario usuario){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/client/usuario/save").toUriString());
        return ResponseEntity.created(uri).body(usuarioRoleService.saveUsuario(usuario));
    }
    
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/client/role/save").toUriString());
        return ResponseEntity.created(uri).body(usuarioRoleService.saveRole(role));
    }
    
    
    @PostMapping("/role/addtousuario")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUsuarioForm form){
        usuarioRoleService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
        
    }
    
    
    @Data
    class RoleToUsuarioForm {
        private String username;
        private String roleName;
    }
    
    
    
    
    

    // Lista todos usuarios
//    @CrossOrigin(origins = "http://localhost:8080/api")
    @CrossOrigin
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
    // Lista todos usuarios por id
    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> obter(@PathVariable Long usuarioId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Adicionar usuario
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario gravar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    // Atualizar usuario
    
    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long usuarioId,
                                             @RequestBody Usuario usuario){
    
        //Verify
        if (!usuarioRepository.existsById(usuarioId)){
            return ResponseEntity.notFound().build();
        }
        
        usuario.setIdUsuario(usuarioId);
        usuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
        
    }
    
    
    
    
    // Deletar o usuario
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> excluir(@PathVariable Long usuarioId) {
        // Verifica se usuario existe ou não
        if(!usuarioRepository.existsById(usuarioId)) {
            return ResponseEntity.notFound().build();
        }
       usuarioService.excluir(usuarioId);
       return ResponseEntity.noContent().build();
    }
}