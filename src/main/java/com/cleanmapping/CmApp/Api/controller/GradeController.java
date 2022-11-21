/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Endpoint: Grade
 */

/*package com.cleanmapping.CmApp.Api.controller;



import com.cleanmapping.CmApp.domain.model.Grade;
import com.cleanmapping.CmApp.domain.repository.GradeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



/**
* Implementa RestController de Usuario
* @author Equipe Clean Mapping - Kaylane e Renan
*/
/*
@RestController
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;
    
    // Lista todos grades
    @GetMapping
    public List<Grade> listar() {
        return gradeRepository.findAll();
    }
    // Lista todas grades por id
    @GetMapping("/gradeId}")
    public ResponseEntity<Grade> obter(@PathVariable Long gradeId) {
        Optional<Grade> usuario = gradeRepository.findById(gradeId);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Adicionar grade
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Grade gravar(@RequestBody Grade grade) {
        return (Grade) gradeRepository.save(grade);
    }
}*/