/**
* Clean Mapping API
*
* Classe Docente
*/
package com.cleanmapping.CmApp.domain.model;

import com.cleanmapping.CmApp.domain.model.status.StatusDocente;
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
public class Docente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="nomedocente")
    private String nomeDocente;
    
    @Column(name="numdocente")
    private int numDocente;
    private String recurso;
    private String obs;
    
    @Enumerated(EnumType.STRING)
    private StatusDocente status;

    public Docente() {
    }

    public Docente(long id, String nomeDocente, int numDocente, String recurso, String obs, StatusDocente status) {
        this.id = id;
        this.nomeDocente = nomeDocente;
        this.numDocente = numDocente;
        this.recurso = recurso;
        this.obs = obs;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public void setNomeDocente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
    }

    public int getNumDocente() {
        return numDocente;
    }

    public void setNumDocente(int numDocente) {
        this.numDocente = numDocente;
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

    public StatusDocente getStatus() {
        return status;
    }

    public void setStatus(StatusDocente status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Docente other = (Docente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
