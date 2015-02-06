package com.rollerhockeyfrance.manager.core.db.entity.discipline;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

@Table(name="DISCIPLINE_INCIDENT")
@Entity
public class Incident extends AbstractEntity {

    private String equipeA;
    private String equipeB;
    private String lieu;
    private DateTime dateHeure;
    private String categorie;
    private String arbitre1;
    private String arbitre2;
    
    public String getEquipeA() {
        return equipeA;
    }
    
    public void setEquipeA(String equipeA) {
        this.equipeA = equipeA;
    }
    
    public String getEquipeB() {
        return equipeB;
    }
    
    public void setEquipeB(String equipeB) {
        this.equipeB = equipeB;
    }
    
    public String getLieu() {
        return lieu;
    }
    
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    public DateTime getDateHeure() {
        return dateHeure;
    }
    
    public void setDateHeure(DateTime dateHeure) {
        this.dateHeure = dateHeure;
    }
    
    public String getCategorie() {
        return categorie;
    }
    
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    public String getArbitre1() {
        return arbitre1;
    }
    
    public void setArbitre1(String arbitre1) {
        this.arbitre1 = arbitre1;
    }
    
    public String getArbitre2() {
        return arbitre2;
    }
    
    public void setArbitre2(String arbitre2) {
        this.arbitre2 = arbitre2;
    }
    
}
