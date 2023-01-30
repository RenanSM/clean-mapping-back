/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cleanmapping.CmApp.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cleanmapping.CmApp.domain.model.Turma;

/**
 *
 * @author devsys-b
 */
@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
    Turma findById(long id);
}
