/**
* Clean Mapping API
*
* Ambiente Repository
*/
package com.cleanmapping.CmApp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cleanmapping.CmApp.domain.model.Ambiente;
import org.springframework.stereotype.Repository;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Long> {
    Ambiente findAmbiente
        
        (long id);
}
