package com.kukushkin.booking.office.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kukushkin.booking.office.entity.Persistent;

public abstract class BaseDao<T extends Persistent> implements Dao<T> {
	private final String UNIT_NAME = "BookingOffice-prod";
	private EntityManagerFactory factory;
	
	protected EntityManager getEntityManger() {
		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		return factory.createEntityManager();
	}
	
	public void add(T persistent) {
		getEntityManger().getTransaction().begin();
		getEntityManger().persist(persistent);
		getEntityManger().getTransaction().commit();
	}
	
	public void delete(T persistent) {
		getEntityManger().getTransaction().begin();
		getEntityManger().remove(persistent);
		getEntityManger().getTransaction().commit();
	}
	
	public void delete(int id) {
	}
}
