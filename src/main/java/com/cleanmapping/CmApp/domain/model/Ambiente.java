/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cleanmapping.CmApp.domain.model;

import com.cleanmapping.CmApp.domain.model.status.StatusAmbiente;
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
public class Ambiente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeAmbiente;
    private int numAmbiente;
    private String obs;
    
    @Enumerated(EnumType.STRING)
    private StatusAmbiente status;

    public Ambiente() {
    }

    public Ambiente(long id, String nomeAmbiente, int numAmbiente, String obs, StatusAmbiente status) {
        this.id = id;
        this.nomeAmbiente = nomeAmbiente;
        this.numAmbiente = numAmbiente;
        this.obs = obs;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public void setNomeAmbiente(String nomeAmbiente) {
        this.nomeAmbiente = nomeAmbiente;
    }

    public int getNumAmbiente() {
        return numAmbiente;
    }

    public void setNumAmbiente(int numAmbiente) {
        this.numAmbiente = numAmbiente;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public StatusAmbiente getStatus() {
        return status;
    }

    public void setStatus(StatusAmbiente status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Ambiente other = (Ambiente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
