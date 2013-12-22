package com.kukushkin.booking.office.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {
	private String DATABASE_PATH = "/home/qualitat1ve/Workplace/eclipse projects/BookingOffice/TESTDB";
	private Connection connection = null;
	private Statement statement = null;

	@BeforeClass
	public void setUp() throws Exception {
		createConnection();
		createTables();
		fillTheTables();
	}

	@AfterClass
	public void tearDown() throws Exception {
		dropTables();
	}
	
	private boolean createTables() {
		createFlightsTable(statement);
		createTicketsTable(statement);
		createReservationsTable(statement);
		createAccountsTable(statement);
		return false;
	}
	
	private boolean dropTables() {
		String dropTableTicketQuery = "drop table TICKET";
		String dropTableReservationQuery = "drop table RESERVATION";
		String dropTableFlightQuery = "drop table FLIGHT";
		String dropTableAccountQuery = "drop table ACCOUNT";
		try {
			statement.execute(dropTableTicketQuery);
			statement.execute(dropTableReservationQuery);
			statement.execute(dropTableFlightQuery);
			statement.execute(dropTableAccountQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return false;
	}
	
	private boolean fillTheTables() {
		fillFlightTable(statement);
		fillReservationTable(statement);
		fillTicketTable(statement);
		fillAccountTable(statement);
		return false;
	}
	
	private void createConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:derby:" + DATABASE_PATH + ";create=true");
			statement = getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() {
		return connection;
	}
	
	private void createFlightsTable(Statement statement) {
		String createFlightsTableQuery = "create table FLIGHT(ID integer not null GENERATED ALWAYS AS IDENTITY,"
			    + "DATE_CREATED timestamp not null,"
			    + "FLIGHTNUMBER varchar(50) not null,"
			    + "DEPARTURE varchar(50) not null,"
			    + "ARRIVAL varchar(50) not null,"
			    + "DATE_DEPARTURE timestamp not null,"
			    + "DATE_ARRIVAL timestamp not null,"
			    + "TICKET_AMOUNT integer not null,"
			    + "TICKET_PRICE integer not null,"
			    + "primary key (ID))";

		try {
			statement.execute(createFlightsTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void createTicketsTable(Statement statement) {
		String createTicketsTableQuery = "create table TICKET(ID integer not null GENERATED ALWAYS AS IDENTITY,"
			    + "FLIGHTID integer constraint FLIGHT_FK references FLIGHT,"
			    + "STATUS smallint not null,"
			    + "RESERVATIONID integer constraint RESERVATIO_FK references RESERVATION,"
			    + "primary key (ID))";
		try {
			statement.execute(createTicketsTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void createAccountsTable(Statement statement){
		String createAccountsTableQuery = "create table ACCOUNT(ID integer not null GENERATED ALWAYS AS IDENTITY,"
			    + "LOGIN varchar(50) not null,"
			    + "PASSWORD varchar(50) not null,"
			    + "SURNAME varchar(50) not null,"
			    + "NAME varchar(50) not null,"
			    + "MIDDLENAME varchar(50) not null,"
			    + "IS_ACTIVE smallint not null,"
			    + "primary key (ID))";
		try {
			statement.execute(createAccountsTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void createReservationsTable(Statement statement){
		String createReservationsTableQuery = "create table RESERVATION (ID integer not null GENERATED ALWAYS AS IDENTITY,"
			    + "CUSTOMER_SURNAME varchar(50) not null,"
			    + "CUSTOMER_NAME varchar(50) not null,"
			    + "CUSTOMER_MIDDLENAME varchar(50) not null,"
			    + "CUSTOMER_ADDRESS varchar(50) not null,"
			    + "DATE_RESERVATION timestamp,"
			    + "DATE_PAYMENT timestamp,"
			    + "primary key (ID))";

		try {
			statement.execute(createReservationsTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void fillFlightTable(Statement statement) {
		String flightFirstRow = "INSERT INTO FLIGHT (DATE_CREATED, FLIGHTNUMBER, DEPARTURE, ARRIVAL, DATE_DEPARTURE, DATE_ARRIVAL, TICKET_AMOUNT, TICKET_PRICE)"
			    + "VALUES ('2013-12-01 10:00:14', 'PS-711', 'Kyiv', 'Stambul', '2013-12-24 06:40:00', '2013-12-24 08:40:00', 10, 1000)";
		String flightSecondRow = "INSERT INTO FLIGHT (DATE_CREATED, FLIGHTNUMBER, DEPARTURE, ARRIVAL, DATE_DEPARTURE, DATE_ARRIVAL, TICKET_AMOUNT, TICKET_PRICE)"
			    + "VALUES ('2013-12-01 10:20:00', 'AQ-021', 'Kyiv', 'Roma', '2013-12-25 10:20:00', '2013-12-25 12:10:00', 5, 1500)";
		String flightThirdRow = "INSERT INTO FLIGHT (DATE_CREATED, FLIGHTNUMBER, DEPARTURE, ARRIVAL, DATE_DEPARTURE, DATE_ARRIVAL, TICKET_AMOUNT, TICKET_PRICE)"
			    + "VALUES ('2013-12-01 10:30:14', 'TF-140', 'Kyiv', 'New York', '2013-12-28 14:35:00', '2013-12-28 23:55:00', 2, 2000)";
		try {
		statement.execute(flightFirstRow);
		statement.execute(flightSecondRow);
		statement.execute(flightThirdRow);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void fillReservationTable(Statement statement) {
		String reservationFirstRow = "INSERT INTO RESERVATION (CUSTOMER_SURNAME, CUSTOMER_NAME, CUSTOMER_MIDDLENAME, CUSTOMER_ADDRESS, DATE_RESERVATION, DATE_PAYMENT)"
				+ "VALUES ('Surname1', 'Name1', 'Middlename1', 'Address1', '2013-12-04 10:00:14', '2013-12-05 10:00:14')";
		String reservationSecondRow = "INSERT INTO RESERVATION (CUSTOMER_SURNAME, CUSTOMER_NAME, CUSTOMER_MIDDLENAME, CUSTOMER_ADDRESS, DATE_RESERVATION, DATE_PAYMENT)"
				+ "VALUES ('Surname2', 'Name2', 'Middlename2', 'Address2', '2013-12-05 10:00:14', '2013-12-06 10:00:14')";
		String reservationThirdRow = "INSERT INTO RESERVATION (CUSTOMER_SURNAME, CUSTOMER_NAME, CUSTOMER_MIDDLENAME, CUSTOMER_ADDRESS, DATE_RESERVATION)"
				+ "VALUES ('Surname3', 'Name3', 'Middlename3', 'Address3', '2013-12-06 10:00:14')";
		try {
			statement.execute(reservationFirstRow);
			statement.execute(reservationSecondRow);
			statement.execute(reservationThirdRow);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void fillTicketTable(Statement statement) {
		String firstTicketRow = "INSERT INTO TICKET (FLIGHTID, STATUS, RESERVATIONID) VALUES (1, 3, 1),"
				+ "(1, 3, 1), (1, 2, 3), (1, 2, 3), (1, 1, null), (1, 1, null), (1, 1, null), (1, 1, null), (1, 1, null), (1, 1, null)";
		String secondTicketRow = "INSERT INTO TICKET (FLIGHTID, STATUS, RESERVATIONID) VALUES (2, 3, 1),"
				+ "(2, 3, 2), (2, 2, 3), (2, 1, null), (2, 1, null)";
		String thirdTicketRow = "INSERT INTO TICKET (FLIGHTID, STATUS, RESERVATIONID) VALUES (3, 3, 2),"
				+ "(3, 1, 2)";
		try {
			statement.execute(firstTicketRow);
			statement.execute(secondTicketRow);
			statement.execute(thirdTicketRow);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private void fillAccountTable(Statement statement) {
		
	}
}
