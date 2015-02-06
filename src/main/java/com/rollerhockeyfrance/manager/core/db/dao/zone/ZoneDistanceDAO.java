package com.rollerhockeyfrance.manager.core.db.dao.zone;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;
import com.rollerhockeyfrance.manager.core.db.dao.AbstractDAO;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZoneDistance;

@NamedNativeQueries(value = { 
		@NamedNativeQuery(
				name = "zone.distance.manquantes", 
				query = "SELECT * " +
						"FROM zone_distance " +
						"") 
})
public class ZoneDistanceDAO extends AbstractDAO<ZoneDistance, Long> {
	
	@Inject
	public ZoneDistanceDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	


	

}
