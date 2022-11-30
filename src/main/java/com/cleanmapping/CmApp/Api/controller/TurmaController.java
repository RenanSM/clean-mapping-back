/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cleanmapping.CmApp.Api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cleanmapping.CmApp.domain.repository.TurmaRepository;
import com.cleanmapping.CmApp.domain.service.TurmaService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.cleanmapping.CmApp.domain.model.Turma;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
* 
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private TurmaService turmaService;    
    
    // Lista todas as turmas 
    @GetMapping
    public List<Turma> listar() {
        return turmaRepository.findAll();
    }
    
    // Lista turma por id
    @GetMapping("/{id}")
    public ResponseEntity<Turma> obter(@PathVariable Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        if (turma.isPresent()) {
            return ResponseEntity.ok(turma.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Adicionar turma
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Turma gravar(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }
    
    // Atualizar turma
    @PutMapping("/{turmaId}")
    public ResponseEntity<Turma> atualizar(@PathVariable Long turmaId,
                                             @RequestBody Turma turma){
        //Verify
        if (!turmaRepository.existsById(turmaId)){
            return ResponseEntity.notFound().build();
        }
        
        turma.setIdTurma(turmaId);
        turma = turmaRepository.save(turma);
        return ResponseEntity.ok(turma);
        
    }
    
    // Deletar turma
    @DeleteMapping("/{turmaId}")
    public ResponseEntity<Void> excluir(@PathVariable Long turmaId) {
        // Verifica se turma existe ou não
        if(!turmaRepository.existsById(turmaId)) {
            return ResponseEntity.notFound().build();
        }
       turmaService.excluir(turmaId);
       return ResponseEntity.noContent().build();
    }
}
