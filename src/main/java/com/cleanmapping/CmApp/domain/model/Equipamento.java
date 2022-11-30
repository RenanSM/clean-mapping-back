/**
* Clean Mapping API
*
* Classe Equipamento
*/
package com.cleanmapping.CmApp.domain.model;



import com.cleanmapping.CmApp.domain.model.status.StatusEquipamento;
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
public class Equipamento{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="nomeequipamento")
    private String nomeEquipamento;
    
    @Column(name="numequipamento")
    private long numEquipamento;
    private String obs;
    
    @Enumerated(EnumType.STRING)
    private StatusEquipamento status;



   public Equipamento() {
    }



   public Equipamento(long id, String nomeEquipamento, long numEquipamento, String obs, StatusEquipamento status) {
        this.id = id;
        this.nomeEquipamento = nomeEquipamento;
        this.numEquipamento = numEquipamento;
        this.obs = obs;
        this.status = status;
    }



   public long getid() {
        return id;
    }



   public void setid(long id) {
        this.id = id;
    }



   public String getNomeEquipamento() {
        return nomeEquipamento;
    }



   public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }



   public long getNumEquipamento() {
        return numEquipamento;
    }



   public void setNumEquipamento(long numEquipamento) {
        this.numEquipamento = numEquipamento;
    }



   public String getObs() {
        return obs;
    }



   public void setObs(String obs) {
        this.obs = obs;
    }



   public StatusEquipamento getStatus() {
        return status;
    }



   public void setStatus(StatusEquipamento status) {
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
        final Equipamento other = (Equipamento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}