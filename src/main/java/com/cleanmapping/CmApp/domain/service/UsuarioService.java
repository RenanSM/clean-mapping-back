/**
* FastFood API
* API básica para melhoria e implementação.
*
* Service: UsuarioService
*/
package com.cleanmapping.CmApp.domain.service;



import com.cleanmapping.CmApp.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository UsuarioRepository;
    
    public void excluir(Long usuarioId) {
        UsuarioRepository.deleteById(usuarioId);
    }
}