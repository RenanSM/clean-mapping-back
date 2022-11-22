/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cleanmapping.CmApp.domain.model;

import com.cleanmapping.CmApp.domain.model.status.StatusTurma;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Devsys-B
 */
@Entity
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeTurma;
    private String numTurma;
    private String obs;
    
    @Enumerated(EnumType.STRING)
    private StatusTurma status;

    public Turma() {
    }

    public Turma(long id, String nomeTurma, String numTurma, String obs, StatusTurma status) {
        this.id = id;
        this.nomeTurma = nomeTurma;
        this.numTurma = numTurma;
        this.obs = obs;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getNumTurma() {
        return numTurma;
    }

    public void setNumTurma(String numTurma) {
        this.numTurma = numTurma;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public StatusTurma getStatus() {
        return status;
    }

    public void setStatus(StatusTurma status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
