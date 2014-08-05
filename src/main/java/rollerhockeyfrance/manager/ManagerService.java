package rollerhockeyfrance.manager;

import rollerhockeyfrance.manager.configuration.ManagerConfiguration;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fiestacabin.dropwizard.guice.AutoConfigService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.json.ObjectMapperFactory;
import com.yammer.dropwizard.migrations.MigrationsBundle;

public class ManagerService extends AutoConfigService<ManagerConfiguration> {

	public ManagerService() {
		super("manager-service", "rollerhockeyfrance.manager");
		hibernateBundle = new HibernateBundle();
	}
	
	private HibernateBundle hibernateBundle;
	
	@Override
	public void initialize(Bootstrap<ManagerConfiguration> bootstrap) {
		bootstrap.setName("roller-hockey-manager");
		
		bootstrap.addBundle(hibernateBundle);
		bootstrap.addBundle(new AssetsBundle("/html", "/app", "index.html"));
		bootstrap.addBundle(new ExceptionBundle());
		bootstrap.addBundle(new MigrationsBundle<ManagerConfiguration>() {
	        public DatabaseConfiguration getDatabaseConfiguration(ManagerConfiguration configuration) {
	            return configuration.getDatabaseConfiguration();
	        }
	    });
	}
	
	@Override
	protected Injector createInjector(ManagerConfiguration configuration) {
		return Guice.createInjector(new ManagerModule(hibernateBundle.getSessionFactory()));
	}

	@Override
	protected void runWithInjector(ManagerConfiguration configuration, Environment environment, Injector injector) throws Exception {
        
		// Prety-print (ressource / json)
        ObjectMapperFactory factory = environment.getObjectMapperFactory();
        factory.enable(SerializationFeature.INDENT_OUTPUT);
       
		// Run with Guice auto config injector
		super.runWithInjector(configuration, environment, injector);
		
	}
	
	public static void main(String[] args) throws Exception {
        new ManagerService().run(args);
    }

}
