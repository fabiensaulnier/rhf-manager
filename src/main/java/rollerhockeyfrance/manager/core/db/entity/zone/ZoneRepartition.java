package rollerhockeyfrance.manager.core.db.entity.zone;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

@Table(name="ZONE_REPARTITION")
@Entity
public class ZoneRepartition extends AbstractEntity {

    @Column
    private String libelle;

    @Column
    private String description;

    @CollectionTable(name = "ZONE_POULE_COLLECTION", joinColumns = @JoinColumn())
    @ElementCollection(fetch = FetchType.LAZY)
    @Column
    private Collection<ZonePoule> poules;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<ZonePoule> getPoules() {
        return poules;
    }

    public void setPoules(Collection<ZonePoule> poules) {
        this.poules = poules;
    }

}
