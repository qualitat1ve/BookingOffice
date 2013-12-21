package com.kukushkin.booking.office.dao;


import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.kukushkin.booking.office.entity.Flight;

public interface FlightDao extends Dao<Flight> {
	List<Flight> findFlights(Date departureDate, String destinationPlace) throws SQLException;
}
