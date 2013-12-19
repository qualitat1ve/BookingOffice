package com.kukushkin.booking.office.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kukushkin.booking.office.entity.Persistent;

public abstract class BaseDao<T extends Persistent> {
	private final String UNIT_NAME = "BookingOffice-prod";
	private EntityManagerFactory factory;
	
	protected EntityManager createEntityManger() {
		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		return factory.createEntityManager();
	}
}
