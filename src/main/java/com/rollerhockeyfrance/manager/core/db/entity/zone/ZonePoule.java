package com.rollerhockeyfrance.manager.core.db.entity.zone;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

@Table(name="ZONE_POULE")
@Entity
public class ZonePoule extends AbstractEntity {

    @Column
    private String libelle;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "ZONE_VILLE")
    private Collection<ZoneVille> ville;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collection<ZoneVille> getVille() {
        return ville;
    }

    public void setVille(Collection<ZoneVille> ville) {
        this.ville = ville;
    }
    
}
