package com.rollerhockeyfrance.manager.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.rollerhockeyfrance.manager.api.common.Api;
import com.rollerhockeyfrance.manager.api.proxy.Classement;
import com.rollerhockeyfrance.manager.api.resultat.Competition;
import com.rollerhockeyfrance.manager.core.resultat.CompetitionService;

@Path("/competitions")
@Produces("application/json; charset=utf-8")
@Consumes("application/json; charset=utf-8")
public class CompetitionsResource {
    
    // http://jsonapi.org/format/
    
    private final CompetitionService competitionService;
    
    @Inject
    public CompetitionsResource(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }
    
    /**
     * Service permettant de récupérer la liste des compétitions de la saison en cours.
     * @return liste des compétitions
     */
    @GET
    @Path("{id}")
    public Api<List<Classement>> getClassement(@PathParam("id") String id) {
        List<Classement> competitions = competitionService.getClassement(id);
        return RessourceUtils.wrap(competitions);
    }
    
    @GET
    public Api<Competition> getCompetition(Optional<Integer> id) {
        
        
        
        Competition competition = competitionService.getCompetition(id.get());
        
        if (competition == null) {
            // Error : NOT FOUND
        }
        
        return RessourceUtils.wrap(competition);
        
    }

}
