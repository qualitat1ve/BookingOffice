package com.kukushkin.booking.office.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.kukushkin.booking.office.entity.Persistent;

import java.util.Calendar;

public abstract class BaseDao<T extends Persistent> implements Dao<T> {
	private final String UNIT_NAME = "BookingOffice-test";
	private EntityManagerFactory factory;
    private EntityManager entityManager;
    private final int RESERVATION_LIFE_TIME = 3;
	
	protected EntityManager getEntityManger() {
        if (entityManager == null) {
            factory = Persistence.createEntityManagerFactory(UNIT_NAME);
            entityManager = factory.createEntityManager();
        }
        return entityManager;
	}
	
	public T add(T persistent) {
		
		//TODO: All transactions should be placed in services!
		getEntityManger().getTransaction().begin();
		getEntityManger().persist(persistent);
        getEntityManger().flush();
        getEntityManger().refresh(persistent);
        getEntityManger().getTransaction().commit();
        return persistent;
	}
	
	public void delete(T persistent) {
		getEntityManger().getTransaction().begin();
		getEntityManger().remove(persistent);
		getEntityManger().getTransaction().commit();
	}

	public void delete(int id) {
        getEntityManger().remove(getEntityManger().getReference(getRealClass(), id));
	}

    public T update(T persistent) {
    	getEntityManger().getTransaction().begin();
        getEntityManger().merge(persistent);
        getEntityManger().getTransaction().commit();
        return persistent;
    }

    public T read(int id) {
        return (T) getEntityManger().find(getRealClass(), id);
    }

    protected abstract Class<T> getRealClass();

    protected java.sql.Date getDeadlineDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -RESERVATION_LIFE_TIME);
        return new java.sql.Date(calendar.getTime().getTime());
    }
}
