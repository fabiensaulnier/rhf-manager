package com.rollerhockeyfrance.manager;

import com.google.common.collect.ImmutableList;
import com.rollerhockeyfrance.manager.configuration.ManagerConfiguration;
import com.rollerhockeyfrance.manager.core.db.entity.Utilisateur;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZoneDistance;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZonePoule;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZoneRepartition;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZoneVille;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.SessionFactoryFactory;

public class HibernateBundle extends com.yammer.dropwizard.hibernate.HibernateBundle<ManagerConfiguration> {

    protected HibernateBundle() {
		super(entities(), factory());
	}

	private static SessionFactoryFactory factory() {
        return new SessionFactoryFactory();
    }

    private static ImmutableList<Class<?>> entities() {
        return ImmutableList.<Class<?>> of(
        		
        		// ZONE
                ZoneRepartition.class,
                ZoneDistance.class,
                ZonePoule.class,
                ZoneVille.class,
                
                
                Utilisateur.class
                
                );
    }
    
    public DatabaseConfiguration getDatabaseConfiguration(ManagerConfiguration configuration) {
        return configuration.getDatabaseConfiguration();
    }

    

}
