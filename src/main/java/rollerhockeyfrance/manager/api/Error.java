package rollerhockeyfrance.manager.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Error {

	@JsonProperty
	private String code;
	
	@JsonProperty
	private String message;
	
	@JsonProperty
	private String field; 
	
	@JsonProperty
	private List<Error> errors;

}
