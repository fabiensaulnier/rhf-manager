package com.rollerhockeyfrance.manager.resources;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.base.Strings;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.rollerhockeyfrance.manager.api.Classement;
import com.rollerhockeyfrance.manager.api.Match;
import com.rollerhockeyfrance.manager.api.Scorebox;
import com.rollerhockeyfrance.manager.api.Statistique;
import com.rollerhockeyfrance.manager.core.resultat.ParseurService;
import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.metrics.annotation.Timed;

/**
 * Resource pour récupérer les informations d'une compétition
 * 
 * Les données sont mises en cache pour éviter d'appeler à chaque fois les serveurs
 * de la fédération.
 * 
 * @author fabiensaulnier
 */
@Singleton
@Path("/competition/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class CompetitionResource {

	@Inject ParseurService parseur;
	
	LoadingCache<CacheKey, Object> cache = CacheBuilder.newBuilder()
				.recordStats()
		       	.build(
		       			new CacheLoader<CacheKey, Object>() {
							@Override
							public Object load(CacheKey key) throws Exception {
								switch (key.t) {
								case CLASSEMENT:
									return parseur.getClassement(key.id);
								
								case MATCHS:
									return parseur.getMatchs(key.id, "ALL", "");

								case SCORE_BOX:
									List<Match> last = parseur.getMatchs(key.id, "LAST", "");
									List<Match> next = parseur.getMatchs(key.id, "NEXT", "");
									Scorebox sb = new Scorebox();
									sb.setLast(Lists.reverse(last));
									sb.setNext(next);
									return sb;
									
								case STATISTIQUE:
									return parseur.getStatistiques(key.id);

								default:
									return null;
								}
							}
		       			});

	public enum CacheType {
		CLASSEMENT, STATISTIQUE, MATCHS, SCORE_BOX
	}
	
	public class CacheKey {
		CacheType t;
		String id;
		public CacheKey(CacheType t, String id) {
			this.t = t; 
			this.id = id;
		}
	}
	
	@Timed
	@GET
	@Path("/classement")
	@SuppressWarnings("unchecked")
	public Response getClassement(@PathParam("id") LongParam id) {
		List<Classement> classement;
		 try {
			classement = (List<Classement>) cache.get(new CacheKey(CacheType.CLASSEMENT, id.get().toString()));
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
	public Response getStatistiques(@PathParam("id") LongParam id) {
		List<Statistique> result;
		 try {
			result = (List<Statistique>) cache.get(new CacheKey(CacheType.STATISTIQUE, id.get().toString()));
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
	public Response getMatchs(@PathParam("id") LongParam id) {
		List<Match> result;
		 try {
			result = (List<Match>) cache.get(new CacheKey(CacheType.MATCHS, id.get().toString()));
			return Response.ok(result).build();
		} catch (ExecutionException e) {
			cache.invalidate("matchs");
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Timed
	@GET
	@Path("/scorebox")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, "application/x-javascript; charset=UTF-8"})
	public Response getScorebox(@PathParam("id") LongParam id, @QueryParam("jsonp") boolean jsonp,
			@DefaultValue("callback") @QueryParam("callback") String callback) {		
		 try {
			Scorebox result = (Scorebox) cache.get(new CacheKey(CacheType.SCORE_BOX, id.get().toString()));
			if(jsonp) {
				JSONPObject json = new JSONPObject(callback, result);
				return Response.ok(json).build();
			} else {
				return Response.ok(result).build();
			}
		} catch (Exception e) {
			cache.invalidate("scorebox");
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("/cache/refresh")
	@Produces(MediaType.TEXT_PLAIN)
	public Response refresh(@PathParam("id") LongParam id, @QueryParam("key") String key) {
		if(Strings.isNullOrEmpty("")) {
			cache.refresh(new CacheKey(CacheType.CLASSEMENT, id.get().toString()));
			cache.refresh(new CacheKey(CacheType.STATISTIQUE, id.get().toString()));
			cache.refresh(new CacheKey(CacheType.MATCHS, id.get().toString()));
			cache.refresh(new CacheKey(CacheType.SCORE_BOX, id.get().toString()));
		} else {
			CacheType type = CacheType.valueOf(key.toUpperCase());
			cache.refresh(new CacheKey(type, id.get().toString()));
		}
		return Response.ok("ok").build();
	}
	
	@GET
	@Path("/cache/stat")
	@Produces(MediaType.TEXT_PLAIN)
	public String cacheStat() {
		final CacheStats cs = cache.stats();
		return cs.toString();
	}
		
}
