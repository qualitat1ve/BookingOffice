package com.kukushkin.booking.office.dao;

import java.sql.Date;
import java.util.List;

import com.kukushkin.booking.office.entity.Flight;

import javax.persistence.TypedQuery;

public class FlightDaoImpl extends BaseDao<Flight> implements FlightDao {

    @Override
    protected Class<Flight> getRealClass() {
        return Flight.class;
    }

	@Override
	public List<Flight> findFlights(Date departureDate, String destinationPlace) {
		String query = "SELECT f FROM Flight f WHERE f.departureDate = ?1 and f.arrival = ?2";
		TypedQuery<Flight> typedQuery = getEntityManger().createQuery(query,
				this.getRealClass());
		List<Flight> availableList = null;

		typedQuery.setParameter(1, departureDate);
		typedQuery.setParameter(2, destinationPlace);
		availableList = typedQuery.getResultList();

		return availableList;
	}
}
