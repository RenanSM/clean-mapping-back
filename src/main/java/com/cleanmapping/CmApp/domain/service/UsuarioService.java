/**
* FastFood API
* API básica para melhoria e implementação.
*
* Service: UsuarioService
*/
package com.cleanmapping.CmApp.domain.service;



import com.cleanmapping.CmApp.domain.model.Usuario;
import com.cleanmapping.CmApp.domain.repository.UsuarioRepository;
import com.cleanmapping.CmApp.domain.security.UsuarioCreateRequest;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Service
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private UsuarioRepository UsuarioRepository;
    private PasswordEncoder passwordEncoder;
    
    public void excluir(Long usuarioId) {
        UsuarioRepository.deleteById(usuarioId);
    }
    
    //Security
    
    public Usuario readUsuarioByUsername(String username){
        return UsuarioRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
    
    public void createUsuario(UsuarioCreateRequest usuarioCreateRequest){
        Usuario usuario = new Usuario();
        Optional<Usuario> byUsername = UsuarioRepository.findByUsername(usuarioCreateRequest.getUsername());
        
        if(byUsername.isPresent()){
            throw new RuntimeException("Usuário já registrado. Por favor use um username diferente");
        }
        usuario.setUsername(usuarioCreateRequest.getUsername());
        usuario.setPassword(passwordEncoder.encode(usuarioCreateRequest.getPassword()));
        UsuarioRepository.save(usuario);
        
        
    }
    
    
    
}