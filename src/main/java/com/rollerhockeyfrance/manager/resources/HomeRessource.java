package com.rollerhockeyfrance.manager.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class HomeRessource {

	@GET
	public Response home() {
		return Response.ok("OK").build();
	}
	
}
