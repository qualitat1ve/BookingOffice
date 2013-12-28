package com.kukushkin.booking.office.dao;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.kukushkin.booking.office.entity.Flight;

public interface FlightDao extends Dao<Flight> {
	List<Flight> findFlights(Timestamp departureDate, String destinationPlace) throws SQLException;
}
