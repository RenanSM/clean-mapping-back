/**
* Clean Mapping API
*
* Ambiente Controller
*/
package com.cleanmapping.CmApp.Api.controller;

import com.cleanmapping.CmApp.domain.repository.AmbienteRepository;
import com.cleanmapping.CmApp.domain.service.AmbienteService;
import com.cleanmapping.CmApp.domain.model.Ambiente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@RestController
@RequestMapping("/ambiente")
public class AmbienteController {
    @Autowired
    private AmbienteRepository ambienteRepository;
    @Autowired
    private AmbienteService ambienteService;
    
    // Lista todas as Ambientes 
    @GetMapping
    public List<Ambiente> listar() {
        return ambienteRepository.findAll();
    }
    
    // Lista Ambiente por id
    @GetMapping("/{id}")
    public ResponseEntity<Ambiente> obter(@PathVariable Long id) {
        Optional<Ambiente> ambiente = ambienteRepository.findById(id);
        if (ambiente.isPresent()) {
            return ResponseEntity.ok(ambiente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Adicionar ambiente
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Ambiente gravar(@RequestBody Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }
    
    // Atualizar ambiente
    @PutMapping("/{ambienteId}")
    public ResponseEntity<Ambiente> atualizar(@PathVariable Long ambienteId,
                                             @RequestBody Ambiente ambiente){
        //Verify
        if (!ambienteRepository.existsById(ambienteId)){
            return ResponseEntity.notFound().build();
        }
        
        ambiente.setId(ambienteId);
        ambiente = ambienteRepository.save(ambiente);
        return ResponseEntity.ok(ambiente);
        
    }
    
    // Deletar ambiente
    @DeleteMapping("/{ambienteId}")
    public ResponseEntity<Void> excluir(@PathVariable Long ambienteId) {
        // Verifica se ambiente existe ou não
        if(!ambienteRepository.existsById(ambienteId)) {
            return ResponseEntity.notFound().build();
        }
       ambienteService.excluir(ambienteId);
       return ResponseEntity.noContent().build();
    }
}
