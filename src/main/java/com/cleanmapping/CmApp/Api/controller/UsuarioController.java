/**
* FastFood API
* API básica para melhoria e implementação.
*
* Endpoint: Usuario
*/
package com.cleanmapping.CmApp.Api.controller;



import com.cleanmapping.CmApp.domain.model.Usuario;
import com.cleanmapping.CmApp.domain.repository.UsuarioRepository;
import com.cleanmapping.CmApp.domain.service.UsuarioService;
import java.util.List;
import java.util.Optional;
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



/**
* Implementa RestController de Usuario
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@RestController
@RequestMapping("/client")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioService usuarioService;



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