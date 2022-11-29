/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Classe Versao
 */
package com.cleanmapping.CmApp.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Equipe Clean Mapping - Kaylane e Renan
 */
@Entity
public class Versao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVersao;
    
    private String nomeVersao;

    public Versao() {
    }

    public Versao(long idVersao, String nomeVersao) {
        this.idVersao = idVersao;
        this.nomeVersao = nomeVersao;
    }

    public long getIdVersao() {
        return idVersao;
    }

    public void setIdVersao(long idVersao) {
        this.idVersao = idVersao;
    }

    public String getNomeVersao() {
        return nomeVersao;
    }

    public void setNomeVersao(String nomeVersao) {
        this.nomeVersao = nomeVersao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.idVersao ^ (this.idVersao >>> 32));
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
        final Versao other = (Versao) obj;
        return this.idVersao == other.idVersao;
    }
 
}
