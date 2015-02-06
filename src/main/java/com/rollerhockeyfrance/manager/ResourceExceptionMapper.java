package com.rollerhockeyfrance.manager;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rollerhockeyfrance.manager.api.common.Error;

/**
 * Classe permettant de réécrire les erreurs 
 * pour avoir une réponse au format JSON interprétable par
 * l'UI.
 * 
 * @author fabiensaulnier
 *
 */
@Provider
public class ResourceExceptionMapper implements ExceptionMapper<Throwable> {

    private static final Logger logger = LoggerFactory.getLogger(ResourceExceptionMapper.class);
    private static final Long ID = new Random().nextLong();

    @Context
    private HttpServletRequest request;
    
    /*
     * (non-Javadoc)
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    public Response toResponse(Throwable exception) {
        String msg = String.format("Error handling a request: %016x", ID);
        logger.error(msg, exception);
        return Response.serverError()
               .type(MediaType.APPLICATION_JSON)
               .entity(this.getJsonError(exception))
               .build();
    }
   
    /**
     * Build JSON error
     * 
     * @param exception
     * @return
     */
    protected Error getJsonError(Throwable exception) {
    	Error error = new Error();
    	//error.setCode(ID.toString());
    	//error.setMessage(exception.getLocalizedMessage());
    	return error;
    }

}
