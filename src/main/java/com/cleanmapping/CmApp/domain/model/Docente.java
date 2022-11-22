/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cleanmapping.CmApp.domain.model;

import com.cleanmapping.CmApp.domain.model.status.StatusDocente;
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
public class Docente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeDocente;
    private int numDocente;
    private String obs;
    
    @Enumerated(EnumType.STRING)
    private StatusDocente status;

    public Docente() {
    }

    public Docente(long id, String nomeDocente, int numDocente, String obs, StatusDocente status) {
        this.id = id;
        this.nomeDocente = nomeDocente;
        this.numDocente = numDocente;
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
