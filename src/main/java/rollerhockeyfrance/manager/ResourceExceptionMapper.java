package rollerhockeyfrance.manager;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rollerhockeyfrance.manager.api.common.Error;

@Provider
public class ResourceExceptionMapper implements ExceptionMapper<Throwable> {

    private static final Logger logger = LoggerFactory.getLogger(ResourceExceptionMapper.class);
    private static final Long ID = new Random().nextLong();

    @Context
    private HttpServletRequest request;
    
    public Response toResponse(Throwable exception) {

        logException(ID, exception);

        if (exception instanceof WebApplicationException) {
            logger.warn("erreur applicative",exception);
            return ((WebApplicationException) exception).getResponse();
        } else {
            return Response.serverError()
                   .type(MediaType.APPLICATION_JSON)
                   .entity(this.getJsonError(exception))
                   .build();
        }
    }


    protected void logException(long id, Throwable exception) {
        String msg = String.format("Error handling a request: %016x", id);
        logger.error(msg, exception);
    }
   
    private Error getJsonError(Throwable exception) {
    	Error error = new Error();
    	//error.setCode(ID.toString());
    	//error.setMessage(exception.getLocalizedMessage());
    	return error;
    }

}
