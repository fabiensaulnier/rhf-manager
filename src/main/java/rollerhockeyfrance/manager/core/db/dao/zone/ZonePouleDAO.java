package rollerhockeyfrance.manager.core.db.dao.zone;

import org.hibernate.SessionFactory;

import rollerhockeyfrance.manager.core.db.entity.zone.ZonePoule;

import com.google.inject.Inject;
import com.yammer.dropwizard.hibernate.AbstractDAO;

public class ZonePouleDAO extends AbstractDAO<ZonePoule> {

	@Inject
	public ZonePouleDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
