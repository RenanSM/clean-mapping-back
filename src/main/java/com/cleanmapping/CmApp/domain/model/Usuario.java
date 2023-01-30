/**
* Clean Mapping API
*
* Classe Usuario
*/
package com.cleanmapping.CmApp.domain.model;



import com.cleanmapping.CmApp.domain.model.status.StatusUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("position")
    private long id;
    private String name;
    
    @JsonProperty("description")
    private String username;
    
    @JsonProperty("symbol")
    private String cpf;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private StatusUsuario status;


    public Usuario() {
    }


    public Usuario(long id, String name, String username, String cpf, String password, StatusUsuario status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.cpf = cpf;
        this.password = password;
        this.status = status;
    }


    public long getIdUsuario() {
        return id;
    }


    public void setIdUsuario(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public StatusUsuario getStatus() {
        return status;
    }


    public void setStatus(StatusUsuario status) {
        this.status = status;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }  
    
}
