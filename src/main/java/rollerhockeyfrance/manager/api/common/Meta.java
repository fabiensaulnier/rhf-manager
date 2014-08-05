package rollerhockeyfrance.manager.api.common;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@JsonInclude(Include.NON_NULL)
public class Meta {
    
    /**
     * PAGINATION
     */
    @JsonProperty private Long total;
    @JsonProperty private Long next;
    @JsonProperty private Long previous;
    
}
