/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Repositorio: Usuario
 */
package com.cleanmapping.CmApp.domain.repository;

import com.cleanmapping.CmApp.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório Usuario
 * @author Equipe Clean Mapping - Kaylane e Renan
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
        
    Usuario findById(long id);
}
