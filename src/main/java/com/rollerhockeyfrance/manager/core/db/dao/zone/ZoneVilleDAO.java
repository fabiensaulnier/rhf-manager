package com.rollerhockeyfrance.manager.core.db.dao.zone;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;
import com.rollerhockeyfrance.manager.core.db.dao.AbstractDAO;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZoneVille;

public class ZoneVilleDAO extends AbstractDAO<ZoneVille, Long> {

	@Inject
	public ZoneVilleDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
