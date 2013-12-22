package com.kukushkin.booking.office.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kukushkin.booking.office.entity.Flight;

public class FlightDaoTest extends BaseTest {
	
	private FlightDaoImpl flightDaoImpl;
	private GregorianCalendar calendar;
	
	@BeforeClass
	public void setUpBeforeClass() {
		flightDaoImpl = new FlightDaoImpl();
		calendar = (GregorianCalendar) Calendar.getInstance();
	}
	
	@AfterClass
	public void tearDownAfterClass() {
		flightDaoImpl = null;
		calendar = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindFlights() {
		//2013-12-24 06:40:00
		//Stambul
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 24);
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.HOUR_OF_DAY, 6);
		calendar.set(Calendar.MINUTE, 40);
		List<Flight> flightsList = flightDaoImpl.findFlights(new Date(calendar.getTime().getTime()), "Stambul");
		
		assertTrue(flightsList.size() == 1);
		
	}

	@Test
	public void testAdd() {
		Flight flight = new Flight();
		flight.setArrival("Ouagadougou");
		calendar.set(2014, Calendar.MAY, 22);
		calendar.getTime().getTime();
		java.sql.Date sqlDate = new Date(calendar.getTime().getTime());
		flight.setArrivalDate(sqlDate);
		flight.setFlightNumber("0011223344");
		flightDaoImpl.add(flight);
		Flight savedFlight = flightDaoImpl.read(4);
		
		assertTrue(savedFlight != null);
		assertTrue(savedFlight.getArrivalDate().equals(sqlDate));
		assertTrue(savedFlight.getFlightNumber().equals("0011223344"));
		assertTrue(savedFlight.getDeparture().equals("Ouagadougou"));
	}

	@Test (expected = SQLException.class)
	public void testDeleteT() {
		Flight flight = flightDaoImpl.read(4);
		assertTrue(flight != null);
		flightDaoImpl.delete(flight);
		Flight deletedFlight = flightDaoImpl.read(flight.getId());
	}

	@Test
	public void testDeleteInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRead() {
		fail("Not yet implemented");
	}

}
