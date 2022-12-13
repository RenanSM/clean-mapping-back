/**
* Clean Mapping API
*
* Equipamento Service
*/
package com.cleanmapping.CmApp.domain.service;

import com.cleanmapping.CmApp.domain.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Service
public class EquipamentoService {
    @Autowired
    private EquipamentoRepository EquipamentoRepository;
    
    public void excluir(Long equipamentoId) {
        EquipamentoRepository.deleteById(equipamentoId);
    }
}
