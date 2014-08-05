package rollerhockeyfrance.manager.api.resultat;

import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
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
}
