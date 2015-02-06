package com.rollerhockeyfrance.manager.core.db.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

public class AbstractDAO<T extends AbstractEntity, PK extends Serializable> extends com.yammer.dropwizard.hibernate.AbstractDAO<T> {

	public AbstractDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
    public T create(T dbObject) {
        return super.persist(dbObject);
    }

    public T update(T dbObject) {       
       return  super.persist(dbObject) ;
    }

    public T delete(T dbObject) {
        super.currentSession().delete(dbObject);
        return dbObject;
    }

    public T deleteById(PK id) {
        // FIXME : trouver une méthode plus performante
    	return delete(getById(id));
    }

    public T getById(PK id) {
        return super.get(id);
    }
    
    @SuppressWarnings("unchecked")
	public List<T> getList() {
    	return currentSession().createCriteria(getEntityClass()).list();
    }
    
    @SuppressWarnings("unchecked")
    public List<T> getList(List<PK> ids) {
        return currentSession().createCriteria(getEntityClass())
                .add(Restrictions.in("id", ids))
                .list();
    }
    
}