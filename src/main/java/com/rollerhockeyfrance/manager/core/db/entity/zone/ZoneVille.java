package com.rollerhockeyfrance.manager.core.db.entity.zone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

@Table(name="ZONE_VILLE")
@Entity
@JsonInclude(Include.NON_NULL)
public class ZoneVille extends AbstractEntity {

    @JsonProperty
    @Column
    private String libelle;

    @JsonProperty
    @Column(name = "code_postal")
    private String codePostal;

    @JsonProperty
    @Column
    private Float latitude;

    @JsonProperty
    @Column
    private Float longitude;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

}
