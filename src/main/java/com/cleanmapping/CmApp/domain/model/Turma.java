/**
* Clean Mapping API
*
* Classe Turma
*/
package com.cleanmapping.CmApp.domain.model;

import com.cleanmapping.CmApp.domain.model.status.StatusTurma;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Entity
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="nometurma")
    private String nomeTurma;
    
    @Column(name="numturma")
    private String numTurma;
    private String recurso;
    private String obs;
    
    @Enumerated(EnumType.STRING)
    private StatusTurma status;

    public Turma() {
    }

    public Turma(long id, String nomeTurma, String numTurma, String recurso, String obs, StatusTurma status) {
        this.id = id;
        this.nomeTurma = nomeTurma;
        this.numTurma = numTurma;
        this.recurso = recurso;
        this.obs = obs;
        this.status = status;
    }

    public long getIdTurma() {
        return id;
    }

    public void setIdTurma(long id) {
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

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
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
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
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