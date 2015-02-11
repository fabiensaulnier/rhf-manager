package com.rollerhockeyfrance.manager.resources;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.base.Objects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.rollerhockeyfrance.manager.api.proxy.Classement;
import com.rollerhockeyfrance.manager.api.proxy.Match;
import com.rollerhockeyfrance.manager.api.proxy.Statistique;
import com.rollerhockeyfrance.manager.core.resultat.ParseurService;
import com.yammer.metrics.annotation.Timed;

/**
 * Resource très bourine temporaire pour avoir déjà quelque chose qui fonctionne
 * pour l'Elite.
 * @author fabiensaulnier
 */
@Singleton
@Path("/elite")
@Produces(MediaType.APPLICATION_JSON)
public class EliteResource {

	@Inject ParseurService parseur;
	
	LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
		       	.build(
		       			new CacheLoader<String, Object>() {
							@Override
							public Object load(String key) throws Exception {
								if(Objects.equal(key, "classement")) {
									return parseur.getClassement("2195");
								} else if(Objects.equal(key, "statistiques")) {
									return parseur.getStatistiques("2195");
								} else if(Objects.equal(key, "matchs")) {
									return parseur.getMatchs("2195", "ALL", "");
								}
								return null;
							}
		       			});

	@Timed
	@GET
	@Path("/classement")
	@SuppressWarnings("unchecked")
	public  Response getClassement() {
		List<Classement> classement;
		 try {
			classement = (List<Classement>) cache.get("classement");
			return Response.ok(classement).build();
		} catch (ExecutionException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Timed
	@GET
	@Path("/statistiques")
	@SuppressWarnings("unchecked")
	public  Response getStatistiques() {
		List<Statistique> result;
		 try {
			result = (List<Statistique>) cache.get("statistiques");
			return Response.ok(result).build();
		} catch (ExecutionException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Timed
	@GET
	@Path("/matchs")
	@SuppressWarnings("unchecked")
	public  Response getMatchs() {
		List<Match> result;
		 try {
			result = (List<Match>) cache.get("matchs");
			return Response.ok(result).build();
		} catch (ExecutionException e) {
			cache.invalidate("matchs");
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Timed
	@GET
	@Path("/refresh")
	@Produces(MediaType.TEXT_PLAIN)
	public Response refresh(@QueryParam("key") String key) {
		cache.refresh(key);
		return Response.ok("ok").build();
	}
	
}
