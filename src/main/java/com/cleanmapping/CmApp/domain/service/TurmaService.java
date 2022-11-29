/**
* FastFood API
* API básica para melhoria e implementação.
*
* Service: TurmaService
*/
package com.cleanmapping.CmApp.domain.service;

import com.cleanmapping.CmApp.domain.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Service
public class TurmaService {
    @Autowired
    private TurmaRepository TurmaRepository;
    
    public void excluir(Long turmaId) {
        TurmaRepository.deleteById(turmaId);
    }
}
