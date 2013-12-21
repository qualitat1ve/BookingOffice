package com.kukushkin.booking.office.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.kukushkin.booking.office.entity.Flight;

public class FlightDaoImpl extends BaseDao<Flight> implements FlightDao {


    @Override
    protected Class<Flight> getRealClass() {
        return Flight.class;
    }


	@Override
	public List<Flight> findFlights(Date departureDate, String destinationPlace) {
		// TODO Auto-generated method stub
		return null;
	}
}
