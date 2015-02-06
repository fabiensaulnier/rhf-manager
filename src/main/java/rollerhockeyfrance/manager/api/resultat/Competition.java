package rollerhockeyfrance.manager.api.resultat;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Competition {
    
    /**
     * Identifiant technique de la compétition
     */
    @JsonProperty
    private Integer id;
    
    /**
     * Nom / Libellé de la compétition
     */
    @JsonProperty
    private String nom;
    
    /**
     * Liste des compétitions "enfants"
     */
    @JsonProperty
    private List<Competition> enfants;
    
    @JsonIgnore
    private boolean hasEnfants() {
        return enfants != null && enfants.size() > 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Competition> getEnfants() {
        return enfants;
    }

    public void setEnfants(List<Competition> enfants) {
        this.enfants = enfants;
    }
    
}
