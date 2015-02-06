package com.rollerhockeyfrance.manager.core.db.dao.zone;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;
import com.rollerhockeyfrance.manager.core.db.dao.AbstractDAO;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZoneRepartition;

public class ZoneRepartitionDAO extends AbstractDAO<ZoneRepartition, Long> {

	@Inject
	public ZoneRepartitionDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
