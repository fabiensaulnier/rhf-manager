package rollerhockeyfrance.manager.api.zone;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZoneRequest {

    @JsonProperty
    private Set<Integer> villes;

    @JsonProperty
    private Integer nbZone;

    public Set<Integer> getVilles() {
        return villes;
    }

    public void setVilles(Set<Integer> villes) {
        this.villes = villes;
    }

    public Integer getNbZone() {
        return nbZone;
    }

    public void setNbZone(Integer nbZone) {
        this.nbZone = nbZone;
    }

}
