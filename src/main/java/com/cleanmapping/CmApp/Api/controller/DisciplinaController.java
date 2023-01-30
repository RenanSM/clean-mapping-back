/**
* Clean Mapping API
*
* Disciplina Controller
*/
package com.cleanmapping.CmApp.Api.controller;

import com.cleanmapping.CmApp.domain.repository.DisciplinaRepository;
import com.cleanmapping.CmApp.domain.service.DisciplinaService;
import com.cleanmapping.CmApp.domain.model.Disciplina;
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
@RequestMapping("/disciplina")
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private DisciplinaService disciplinaService;
    
    // Lista todas as disciplinas 
    @GetMapping
    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }
    
    // Lista disciplina por id
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> obter(@PathVariable Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isPresent()) {
            return ResponseEntity.ok(disciplina.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Adicionar disciplina
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Disciplina gravar(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }
    
    // Atualizar disciplina
    @PutMapping("/{disciplinaId}")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Long disciplinaId,
                                             @RequestBody Disciplina disciplina){
        //Verify
        if (!disciplinaRepository.existsById(disciplinaId)){
            return ResponseEntity.notFound().build();
        }
        
        disciplina.setId(disciplinaId);
        disciplina = disciplinaRepository.save(disciplina);
        return ResponseEntity.ok(disciplina);
        
    }
    
    // Deletar disciplina
    @DeleteMapping("/{disciplinaId}")
    public ResponseEntity<Void> excluir(@PathVariable Long disciplinaId) {
        // Verifica se disciplina existe ou não
        if(!disciplinaRepository.existsById(disciplinaId)) {
            return ResponseEntity.notFound().build();
        }
       disciplinaService.excluir(disciplinaId);
       return ResponseEntity.noContent().build();
    }
}
