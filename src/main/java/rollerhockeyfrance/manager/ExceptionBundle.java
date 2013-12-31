package rollerhockeyfrance.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ext.ExceptionMapper;

import com.sun.jersey.api.core.ResourceConfig;
import com.yammer.dropwizard.Bundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class ExceptionBundle implements Bundle {

	public void initialize(Bootstrap<?> bootstrap) {

	}

	public void run(Environment environment) {
		
        // Remove all of Dropwizard's custom ExceptionMappers
        ResourceConfig jrConfig = environment.getJerseyResourceConfig();
        Set<Object> dwSingletons = jrConfig.getSingletons();
        List<Object> singletonsToRemove = new ArrayList<Object>();

        for (Object s : dwSingletons) {
            if (s instanceof ExceptionMapper && s.getClass().getName().startsWith("com.yammer.dropwizard.jersey.")) {
                singletonsToRemove.add(s);
            }
        }

        for (Object s : singletonsToRemove) {
            jrConfig.getSingletons().remove(s);
        }

        // Register the custom ExceptionMapper(s)
        environment.addProvider(new ResourceExceptionMapper());
		
	}

}
