/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Classe Grade
 */
package com.cleanmapping.CmApp.domain.model;


import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Equipe Clean Mapping - Kaylane e Renan
 */
@Entity
public class Grade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGrade;
    
    //Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
    private LocalTime hours;
    //Represents a date (year, month, day (yyyy-MM-dd))
    private LocalDate dayWeek;
    
    //add FK idVersao
    @ManyToOne
    private Versao versao;
    
    public Grade() {
    }

    public Grade(long idGrade, LocalTime hours, LocalDate dayWeek) {
        this.idGrade = idGrade;
        this.hours = hours;
        this.dayWeek = dayWeek;
    }
    
    public long getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(long idGrade) {
        this.idGrade = idGrade;
    }

    public LocalTime getHours() {
        return hours;
    }

    public void setHours(LocalTime hours) {
        this.hours = hours;
    }

    public LocalDate getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(LocalDate dayWeek) {
        this.dayWeek = dayWeek;
    }

    public Versao getVersao() {
        return versao;
    }

    public void setVersao(Versao versao) {
        this.versao = versao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.idGrade ^ (this.idGrade >>> 32));
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
        final Grade other = (Grade) obj;
        return this.idGrade == other.idGrade;
    }

    
    
    
}
