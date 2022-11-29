/**
* Clean Mapping API
*
* Disciplina Service
*/
package com.cleanmapping.CmApp.domain.service;

import com.cleanmapping.CmApp.domain.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository DisciplinaRepository;
    
    public void excluir(Long disciplinaId) {
        DisciplinaRepository.deleteById(disciplinaId);
    }
}
