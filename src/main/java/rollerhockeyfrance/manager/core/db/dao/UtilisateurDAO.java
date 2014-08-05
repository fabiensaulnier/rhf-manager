package rollerhockeyfrance.manager.core.db.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;

import rollerhockeyfrance.manager.core.db.entity.Utilisateur;

public class UtilisateurDAO extends AbstractDAO<Utilisateur, Long>{

	@Inject
	public UtilisateurDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public Utilisateur getUtilisateur(String email, String password) {
		return (Utilisateur) currentSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
	}

}
