/**
* Clean Mapping API
*
* Docente Controller
*/
package com.cleanmapping.CmApp.Api.controller;

import com.cleanmapping.CmApp.domain.model.Docente;
import com.cleanmapping.CmApp.domain.repository.DocenteRepository;
import com.cleanmapping.CmApp.domain.service.DocenteService;
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
@RequestMapping("/docente")
public class DocenteController {
    @Autowired
    private DocenteRepository docenteRepository;
    @Autowired
    private DocenteService docenteService;
 
    // Lista todas as docentes 
    @GetMapping
    public List<Docente> listar() {
        return docenteRepository.findAll();
    }
    
    // Lista docentes por id
    @GetMapping("/{id}")
    public ResponseEntity<Docente> obter(@PathVariable Long id) {
        Optional<Docente> docente = docenteRepository.findById(id);
        if (docente.isPresent()) {
            return ResponseEntity.ok(docente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Adicionar docente
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Docente gravar(@RequestBody Docente docente) {
        return docenteRepository.save(docente);
    }
    
    // Atualizar docente
    @PutMapping("/{docenteId}")
    public ResponseEntity<Docente> atualizar(@PathVariable Long docenteId,
                                             @RequestBody Docente docente){
        //Verify
        if (!docenteRepository.existsById(docenteId)){
            return ResponseEntity.notFound().build();
        }
        
        docente.setId(docenteId);
        docente = docenteRepository.save(docente);
        return ResponseEntity.ok(docente);
        
    }
    
    // Deletar docente
    @DeleteMapping("/{docenteId}")
    public ResponseEntity<Void> excluir(@PathVariable Long docenteId) {
        // Verifica se docente existe ou não
        if(!docenteRepository.existsById(docenteId)) {
            return ResponseEntity.notFound().build();
        }
       docenteService.excluir(docenteId);
       return ResponseEntity.noContent().build();
    }
}
