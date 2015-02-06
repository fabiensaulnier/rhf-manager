package com.rollerhockeyfrance.manager.core.common;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.rollerhockeyfrance.manager.core.db.dao.UtilisateurDAO;
import com.rollerhockeyfrance.manager.core.db.entity.Utilisateur;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.auth.basic.BasicCredentials;

public class UtilisateurService implements Authenticator<BasicCredentials, Utilisateur> {
	
	@Inject
	private UtilisateurDAO utilisateurDAO;
	
	public Optional<Utilisateur> authenticate(BasicCredentials credentials) throws AuthenticationException {
		return Optional.fromNullable(utilisateurDAO.getUtilisateur(credentials.getUsername(), credentials.getPassword()));
	}
	
	

}
