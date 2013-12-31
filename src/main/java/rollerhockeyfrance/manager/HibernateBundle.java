package rollerhockeyfrance.manager;

import com.google.common.collect.ImmutableList;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.SessionFactoryFactory;

import rollerhockeyfrance.manager.configuration.ManagerConfiguration;
import rollerhockeyfrance.manager.core.db.entity.zone.ZoneRepartition;
import rollerhockeyfrance.manager.core.db.entity.zone.ZoneDistance;
import rollerhockeyfrance.manager.core.db.entity.zone.ZonePoule;
import rollerhockeyfrance.manager.core.db.entity.zone.ZoneVille;

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
                ZoneVille.class
                
                );
    }
    
    public DatabaseConfiguration getDatabaseConfiguration(ManagerConfiguration configuration) {
        return configuration.getDatabaseConfiguration();
    }

    

}
