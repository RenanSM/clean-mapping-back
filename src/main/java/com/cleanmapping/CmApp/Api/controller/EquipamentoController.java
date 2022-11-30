/**
* Clean Mapping API
*
* Equipamento Controller
*/
package com.cleanmapping.CmApp.Api.controller;

import com.cleanmapping.CmApp.domain.model.Equipamento;
import com.cleanmapping.CmApp.domain.repository.EquipamentoRepository;
import com.cleanmapping.CmApp.domain.service.EquipamentoService;
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
@RequestMapping("/equipamento")
public class EquipamentoController {
    @Autowired
    private EquipamentoRepository equipamentoRepository;
    @Autowired
    private EquipamentoService equipamentoService;
 
    // Lista todas as equipamentos 
    @GetMapping
    public List<Equipamento> listar() {
        return equipamentoRepository.findAll();
    }
    
    // Lista equipamentos por id
    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> obter(@PathVariable Long id) {
        Optional<Equipamento> equipamento = equipamentoRepository.findById(id);
        if (equipamento.isPresent()) {
            return ResponseEntity.ok(equipamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Adicionar equipamento
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipamento gravar(@RequestBody Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }
    
    // Atualizar equipamento
    @PutMapping("/{equipamentoId}")
    public ResponseEntity<Equipamento> atualizar(@PathVariable Long equipamentoId,
                                             @RequestBody Equipamento equipamento){
        //Verify
        if (!equipamentoRepository.existsById(equipamentoId)){
            return ResponseEntity.notFound().build();
        }
        
        equipamento.setid(equipamentoId);
        equipamento = equipamentoRepository.save(equipamento);
        return ResponseEntity.ok(equipamento);
        
    }
    
    // Deletar equipamento
    @DeleteMapping("/{equipamentoId}")
    public ResponseEntity<Void> excluir(@PathVariable Long equipamentoId) {
        // Verifica se equipamento existe ou não
        if(!equipamentoRepository.existsById(equipamentoId)) {
            return ResponseEntity.notFound().build();
        }
       equipamentoService.excluir(equipamentoId);
       return ResponseEntity.noContent().build();
    }
}
