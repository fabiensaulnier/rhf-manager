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
import com.rollerhockeyfrance.manager.api.Competition;
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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((t == null) ? 0 : t.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CacheKey other = (CacheKey) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (t != other.t)
				return false;
			return true;
		}
		private CompetitionResource getOuterType() {
			return CompetitionResource.this;
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
			System.out.println(e);
			return Response.serverError().build();
		}
	}
	
	@Timed
	@GET
	@Path("/statistiques")
	@SuppressWarnings("unchecked")
	public Response getStatistiques(@PathParam("id") LongParam id) {
		List<Statistique> result;
		CacheKey key = new CacheKey(CacheType.STATISTIQUE, id.get().toString());
		 try {
			result = (List<Statistique>) cache.get(key);
			return Response.ok(result).build();
		} catch (ExecutionException e) {
			e.printStackTrace();
			cache.invalidate(key);
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
			e.printStackTrace();
			cache.invalidate(CacheType.MATCHS);
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
			e.printStackTrace();
			cache.invalidate(CacheType.SCORE_BOX);
			return Response.serverError().build();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Timed
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, "application/x-javascript; charset=UTF-8"})
	public Response getAll(@PathParam("id") LongParam id, @QueryParam("jsonp") boolean jsonp,
			@DefaultValue("callback") @QueryParam("callback") String callback) {	
		 try {
			List<Classement> classement = (List<Classement>) cache.get(new CacheKey(CacheType.CLASSEMENT, id.get().toString()));
			List<Statistique> statistiques = (List<Statistique>) cache.get(new CacheKey(CacheType.STATISTIQUE, id.get().toString()));
			List<Match> matchs = (List<Match>) cache.get(new CacheKey(CacheType.MATCHS, id.get().toString()));
			
			Competition competition = new Competition();
			competition.setClassement(classement);
			competition.setStatistiques(statistiques);
			competition.setMatchs(matchs);
			
			if(jsonp) {
				JSONPObject json = new JSONPObject(callback, competition);
				return Response.ok(json).build();
			} else {
				return Response.ok(competition).build();
			}
		} catch (Exception e) {
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
