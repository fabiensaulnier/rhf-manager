package rollerhockeyfrance.manager.resources.resultat;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import rollerhockeyfrance.manager.api.common.Api;
import rollerhockeyfrance.manager.api.resultat.Competition;
import rollerhockeyfrance.manager.core.resultat.CompetitionService;
import rollerhockeyfrance.manager.resources.RessourceUtils;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("/resultat/competitions")
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
    public Api<List<Competition>> getCompetitions() {
        List<Competition> competitions = competitionService.getCompetitions();
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
