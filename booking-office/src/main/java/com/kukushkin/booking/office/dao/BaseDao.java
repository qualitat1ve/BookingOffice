package com.kukushkin.booking.office.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.kukushkin.booking.office.entity.Persistent;

public abstract class BaseDao<T extends Persistent> implements Dao<T> {
	private final String UNIT_NAME = "BookingOffice-prod";
	private EntityManagerFactory factory;
    private EntityManager entityManager;
	
	protected EntityManager getEntityManger() {
        if (entityManager == null) {
            factory = Persistence.createEntityManagerFactory(UNIT_NAME);
            entityManager = factory.createEntityManager();
        }
        return entityManager;
	}
	
	public T add(T persistent) {
		getEntityManger().persist(persistent);
        getEntityManger().flush();
        getEntityManger().refresh(persistent);
        return persistent;
	}
	
	public void delete(T persistent) {
		getEntityManger().remove(persistent);
	}

	public void delete(int id) {
        getEntityManger().remove(getEntityManger().getReference(getRealClass(), id));
	}

    public T update(T persistent) {
        return getEntityManger().merge(persistent);
    }

    public T read(int id) {
        return (T) getEntityManger().find(getRealClass(), id);
    }

    protected abstract Class<T> getRealClass();
}
