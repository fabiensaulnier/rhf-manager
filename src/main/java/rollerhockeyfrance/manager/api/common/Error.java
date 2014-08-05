package rollerhockeyfrance.manager.api.common;

import lombok.Data;

import org.eclipse.jetty.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(Include.NON_NULL)
public class Error {

	@JsonProperty
	private String id;
	
	@JsonProperty
	private HttpStatus status;
	
	@JsonProperty
	private Code code;
	
	@JsonProperty
	private String title;
	
	@JsonProperty
	private String detail;
		
    public enum Code {
        NOT_FOUND
    }

}
