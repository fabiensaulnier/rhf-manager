package rollerhockeyfrance.manager.core.db.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.google.common.base.Optional;
import com.google.inject.Inject;

public class HealthCheckDAO {

	private SessionFactory sessionFactory;
	
	@Inject
	public HealthCheckDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Optional<Integer> ping() {
		Query query = this.sessionFactory.openSession().createSQLQuery("SELECT 1");
		return Optional.fromNullable((Integer)query.uniqueResult());
	}
}
