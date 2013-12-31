package rollerhockeyfrance.manager.api.zone;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ZoneRequest {
	
	@JsonProperty
	private Set<Integer> villes;
	
	@JsonProperty
	private Integer nbZone;

}
