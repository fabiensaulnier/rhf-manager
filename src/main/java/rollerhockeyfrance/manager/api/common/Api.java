package rollerhockeyfrance.manager.api.common;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@JsonInclude(Include.NON_NULL)
public class Api<T> {
    
    /**
     * Statut de la requête
     */
    @JsonProperty
    private Status status;
	
    @JsonProperty
	private T data;
    
    @JsonProperty
    private Error error;
    
    @JsonProperty
    private Meta meta;

    public enum Status {
        OK, ERROR
    }
	
}
