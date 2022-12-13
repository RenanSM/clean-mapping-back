/**
* Clean Mapping API
*
* Equipamento Repository
*/
package com.cleanmapping.CmApp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cleanmapping.CmApp.domain.model.Equipamento;
import org.springframework.stereotype.Repository;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>{
    Equipamento findById(long id);
}
