package rollerhockeyfrance.manager.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rollerhockeyfrance.manager.core.common.UtilisateurService;
import rollerhockeyfrance.manager.core.db.entity.Utilisateur;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("/utilisateur")
@Produces(MediaType.APPLICATION_JSON)
public class UtilisateurResource {
	
	private final UtilisateurService utilisateurService;
	
	@Inject
	public UtilisateurResource(UtilisateurService utilisateurService)  {
		this.utilisateurService = utilisateurService;
	}
	
	@POST
	public Response login(String login, String password) {
		return null;
		
		//utilisateurService.authenticate(credentials);
		
	}

}
