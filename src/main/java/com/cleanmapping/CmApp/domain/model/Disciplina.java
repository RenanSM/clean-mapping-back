/**
* Clean Mapping API
*
* Classe Disciplina
*/
package com.cleanmapping.CmApp.domain.model;



import com.cleanmapping.CmApp.domain.model.status.StatusDisciplina;
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
public class Disciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDisciplina;
    private String nomeDisciplina;
    private String obs;
    
    @Enumerated(EnumType.STRING)
    private StatusDisciplina status;



   public Disciplina() {
    }



   public Disciplina(long idDisciplina, String nomeDisciplina, String obs, StatusDisciplina status) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.obs = obs;
        this.status = status;
    }



   public long getIdDisciplina() {
        return idDisciplina;
    }



   public void setIdDisciplina(long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }



   public String getNomeDisciplina() {
        return nomeDisciplina;
    }



   public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }



   public String getObs() {
        return obs;
    }



   public void setObs(String obs) {
        this.obs = obs;
    }



   public StatusDisciplina getStatus() {
        return status;
    }



   public void setStatus(StatusDisciplina status) {
        this.status = status;
    }



   @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.idDisciplina ^ (this.idDisciplina >>> 32));
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
        final Disciplina other = (Disciplina) obj;
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        return true;
    }
    
    
}