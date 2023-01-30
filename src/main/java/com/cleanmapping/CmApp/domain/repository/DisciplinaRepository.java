/**
* Clean Mapping API
*
* Disciplina Repository
*/
package com.cleanmapping.CmApp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cleanmapping.CmApp.domain.model.Disciplina;
import org.springframework.stereotype.Repository;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    Disciplina findById(long id);
}
