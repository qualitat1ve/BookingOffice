package com.kukushkin.booking.office.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kukushkin.booking.office.entity.Flight;


public class FlightDaoTest extends BaseTest {
	
	private static FlightDaoImpl flightDaoImpl;
	private static GregorianCalendar calendar;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		flightDaoImpl = new FlightDaoImpl();
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		flightDaoImpl = null;
		calendar = null;
	}
	
	@Before
	public void setUp() throws Exception {
		calendar = new GregorianCalendar();
	}
	
	@Test
	public void testFindFlights() {
		//2013-12-24 06:40:00
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 24);
		calendar.set(Calendar.HOUR_OF_DAY, 6);
		calendar.set(Calendar.MINUTE, 40);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		List<Flight> flightsList = flightDaoImpl.findFlights(new java.sql.Timestamp(calendar.getTime().getTime()), "Stambul");
		assertTrue(flightsList.size() == 1);
	}

	@Test
	public void testAdd() {
		Flight flight = new Flight();
		flight.setArrival("Ouagadougou");
		Timestamp sqlDate = new Timestamp(calendar.getTime().getTime());
		flight.setArrivalDate(sqlDate);
		flight.setFlightNumber("0011223344");
		flight.setCreationDate(new Timestamp(new java.util.Date().getTime()));
		flight.setDeparture("Kiev");
		flight.setDepartureDate(new Timestamp(new java.util.Date().getTime()));
		flight.setTicketNumber(15);
		flight.setTicketPrice(10);
		flightDaoImpl.add(flight);
		Flight savedFlight = flightDaoImpl.read(flight.getId());
		
		assertTrue(savedFlight != null);
		assertTrue(flight.getCreationDate().equals(savedFlight.getCreationDate()));
		assertTrue(flight.getFlightNumber().equals(savedFlight.getFlightNumber()));
		assertTrue(flight.getArrival().equals(savedFlight.getArrival()));
		assertTrue(flight.getArrivalDate().equals(savedFlight.getArrivalDate()));
		assertTrue(flight.getDeparture().equals(savedFlight.getDeparture()));
		assertTrue(flight.getDepartureDate().equals(savedFlight.getDepartureDate()));
		assertTrue(flight.getTicketNumber() == (savedFlight.getTicketNumber()));
		assertTrue(flight.getTicketPrice() == (savedFlight.getTicketPrice()));
	}
	
	@Test
	public void testDelete() {
		Flight flight = flightDaoImpl.read(4);
		assertTrue(flight != null);
		flightDaoImpl.delete(flight);
		Flight deletedFlight = flightDaoImpl.read(flight.getId());
		assertTrue(deletedFlight == null);
	}

	@Test
	public void testUpdate() {
		Flight flight = flightDaoImpl.read(1);
		int oldTicketsNumber = flight.getTicketNumber();
		int newTicketNumber = oldTicketsNumber++;
		flight.setTicketNumber(newTicketNumber);
		flightDaoImpl.update(flight);
		Flight updatedFlight = flightDaoImpl.read(1);
		assertFalse(updatedFlight.getTicketNumber() == oldTicketsNumber);
		assertTrue(updatedFlight.getTicketNumber() == newTicketNumber);
	}

	@Test
	public void testRead() {
		Flight flight = null;
		flight = flightDaoImpl.read(1);
		assertTrue(flight != null);
	}

}
