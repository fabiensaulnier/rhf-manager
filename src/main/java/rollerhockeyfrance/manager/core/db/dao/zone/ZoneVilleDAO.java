package rollerhockeyfrance.manager.core.db.dao.zone;

import org.hibernate.SessionFactory;

import rollerhockeyfrance.manager.core.db.dao.AbstractDAO;
import rollerhockeyfrance.manager.core.db.entity.zone.ZoneVille;

import com.google.inject.Inject;

public class ZoneVilleDAO extends AbstractDAO<ZoneVille, Long> {

	@Inject
	public ZoneVilleDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
