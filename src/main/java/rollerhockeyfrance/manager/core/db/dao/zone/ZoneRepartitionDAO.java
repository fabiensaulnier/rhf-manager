package rollerhockeyfrance.manager.core.db.dao.zone;

import org.hibernate.SessionFactory;

import rollerhockeyfrance.manager.core.db.dao.AbstractDAO;
import rollerhockeyfrance.manager.core.db.entity.zone.ZoneRepartition;

import com.google.inject.Inject;

public class ZoneRepartitionDAO extends AbstractDAO<ZoneRepartition, Long> {

	@Inject
	public ZoneRepartitionDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
