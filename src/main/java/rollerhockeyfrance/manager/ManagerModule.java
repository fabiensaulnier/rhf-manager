package rollerhockeyfrance.manager;

import org.hibernate.SessionFactory;

import rollerhockeyfrance.manager.core.db.dao.zone.ZoneVilleDAO;

import com.google.inject.AbstractModule;

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

		bind(ZoneVilleDAO.class).toInstance(new ZoneVilleDAO(sessionFactory));
		
	}

}