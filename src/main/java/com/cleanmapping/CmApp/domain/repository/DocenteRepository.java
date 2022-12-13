/**
* Clean Mapping API
*
* Docente Repository
*/
package com.cleanmapping.CmApp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cleanmapping.CmApp.domain.model.Docente;
import org.springframework.stereotype.Repository;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long>{
    Docente findById(long id);
}
