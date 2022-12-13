/**
* Clean Mapping API
*
* Equipamento Service
*/
package com.cleanmapping.CmApp.domain.service;

import com.cleanmapping.CmApp.domain.repository.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Service
public class AmbienteService {
    @Autowired
    private AmbienteRepository ambienteRepository;
    
    public void excluir(Long ambienteId) {
        ambienteRepository.deleteById(ambienteId);
    }
}
