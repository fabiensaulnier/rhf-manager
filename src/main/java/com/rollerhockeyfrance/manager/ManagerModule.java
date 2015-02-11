package com.rollerhockeyfrance.manager;

import org.hibernate.SessionFactory;

import com.google.inject.AbstractModule;
import com.rollerhockeyfrance.manager.core.db.dao.HealthCheckDAO;
import com.rollerhockeyfrance.manager.core.db.dao.UtilisateurDAO;
import com.rollerhockeyfrance.manager.core.db.dao.zone.ZoneVilleDAO;
import com.rollerhockeyfrance.manager.resources.CompetitionsResource;


/**
 * Module permettant de gérer l'injection des dépendances à Guice
 * 
 * @author fabiensaulnier
 *
 */
public class ManagerModule extends AbstractModule {
	
	private final SessionFactory sessionFactory;
	
	public ManagerModule(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	protected void configure() {

	    // DAO binding
		bind(ZoneVilleDAO.class).toInstance(new ZoneVilleDAO(sessionFactory));
		bind(UtilisateurDAO.class).toInstance(new UtilisateurDAO(sessionFactory));
		bind(HealthCheckDAO.class).toInstance(new HealthCheckDAO(sessionFactory));

	}

}
