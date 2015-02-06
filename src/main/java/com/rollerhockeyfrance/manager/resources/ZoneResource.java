package com.rollerhockeyfrance.manager.resources;

import java.io.File;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;

import org.joda.time.DateTime;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZoneVille;
import com.rollerhockeyfrance.manager.core.zone.VilleService;
import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.dropwizard.jersey.params.IntParam;
import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.dropwizard.validation.Validated;
import com.yammer.metrics.annotation.Timed;

@Singleton
@Path("/zone")
@Produces(MediaType.APPLICATION_JSON)
public class ZoneResource {
	
	private final VilleService villeService;

	@Inject
	public ZoneResource(VilleService villeService) {
	    this.villeService = villeService;
	}
	
	// REPARTITIONS

	@POST
	public void calculerZone () {
		
	}
	
	@GET
	@Path("/export/{id}")
	@Timed
	@Produces("application/pdf")
	public Response exportPDF(@PathParam(value = "id") IntParam id) {
		
		String filename = "export-zone-" + id + "-" + DateTime.now() +".pdf";
		
		File file = null;
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=" + filename);
		return response.build();
	}
	
	// POULES
	
	// DISTANCES
	
	@GET
	@Path("/distance/{ville1}/{ville2}")
	public Response distance(
			@PathParam(value = "ville1") IntParam ville1,
			@PathParam(value = "ville2") IntParam ville2) {
		
		// TODO
		return null;
		
	}
	
	// VILLES

	@POST
	@Path("/villes")
	@Consumes("application/json; charset=utf-8")
	public Response createVille(@Validated ZoneVille ville) {
		ZoneVille villeCreated = villeService.create(ville);
		return Response.created(UriBuilder.fromResource(ZoneResource.class)
										  .build(ville, villeCreated))
					   .build();
	}
	
	@GET
	@Path("/villes/{id}")
	public Response readVille(@PathParam(value = "id") LongParam id) {
		Optional<ZoneVille> ville = Optional.fromNullable(villeService.read(id.get()));
		if(ville.isPresent()) {
			return Response.ok(ville).build();
		}
		return Response.noContent().build();
	}
	
	@UnitOfWork
	@GET
	@Path("/villes")
	public Response readAddVille() {
		// TODO : pagination
		List<ZoneVille> villes = villeService.findAll();
		return Response.ok(villes).build();
	}
	
	@PUT
	@Path("/villes")
	public Response updateVille(@Validated ZoneVille ville) {
		Optional<ZoneVille> villeUpdated = Optional.of(villeService.update(ville));
		if(villeUpdated.isPresent()) {
			return Response.ok(ville).build();
		}
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/villes/{id}")
	public Response deleteVille(@PathParam(value = "id") LongParam id) {
		Optional<ZoneVille> villeDeleted = Optional.of(villeService.delete(id.get()));
		if(villeDeleted.isPresent()) {
			return Response.ok(villeDeleted).build();
		}
		return Response.noContent().build();
	}
	
}