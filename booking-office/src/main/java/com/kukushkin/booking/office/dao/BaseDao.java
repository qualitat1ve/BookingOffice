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
	
	public void add(T persistent) {
		getEntityManger().persist(persistent);
	}
	
	public void delete(T persistent) {
		getEntityManger().remove(persistent);
	}

	public void delete(int id) {
        getEntityManger().getTransaction().begin();
        getEntityManger().remove(getEntityManger().find(getType(), id));
	}

    public void update(T persistent) {
        getEntityManger().persist(persistent);
    }

    protected abstract Class<T> getType();
}
