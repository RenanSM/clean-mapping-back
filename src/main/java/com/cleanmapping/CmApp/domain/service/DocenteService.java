/**
* Clean Mapping API
*
* Docente Service
*/
package com.cleanmapping.CmApp.domain.service;

import com.cleanmapping.CmApp.domain.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Service
public class DocenteService {
    @Autowired
    private DocenteRepository DocenteRepository;
    
    public void excluir(Long docenteId) {
        DocenteRepository.deleteById(docenteId);
    }
}
