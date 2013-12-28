package com.kukushkin.booking.office.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {
	private static String DATABASE_PATH = "../TESTDB";
	private static Connection connection = null;
	private static Statement statement = null;

	@BeforeClass
	public static void setUpClass() throws Exception {
		createConnection();
		createTables();
		fillTheTables();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		dropTables();
        closeConnection();
	}

    private static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean createTables() {
		createAccountsTable(statement);
		createFlightsTable(statement);
		createReservationsTable(statement);
		createTicketsTable(statement);
		return false;
	}
	
	private static void dropTables() {
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
		}
	}
	
	private static boolean fillTheTables() {
		fillFlightTable(statement);
		fillReservationTable(statement);
		fillTicketTable(statement);
		fillAccountTable(statement);
		return false;
	}
	
	private static void createConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:derby:" + DATABASE_PATH + ";create=true");
			statement = getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected static Connection getConnection() {
		return connection;
	}
	
	private static void createFlightsTable(Statement statement) {
		String createFlightsTableQuery = "create table FLIGHT(ID integer not null GENERATED ALWAYS AS IDENTITY,"
			    + "CREATIONDATE timestamp not null,"
			    + "FLIGHTNUMBER varchar(50) not null,"
			    + "DEPARTURE varchar(50) not null,"
			    + "ARRIVAL varchar(50) not null,"
			    + "DEPARTUREDATE timestamp not null,"
			    + "ARRIVALDATE timestamp not null,"
			    + "TICKETNUMBER integer not null,"
			    + "TICKETPRICE integer not null,"
			    + "primary key (ID))";

		try {
			statement.execute(createFlightsTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void createTicketsTable(Statement statement) {
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

	private static void createAccountsTable(Statement statement){
		String createAccountsTableQuery = "create table ACCOUNT(ID integer not null GENERATED ALWAYS AS IDENTITY,"
			    + "LOGIN varchar(50) not null,"
			    + "PASSWORD varchar(50) not null,"
			    + "USERSURNAME varchar(50) not null,"
			    + "USERNAME varchar(50) not null,"
			    + "USERMIDDLENAME varchar(50) not null,"
                + "USERROLE smallint not null,"
			    + "ISACTIVE boolean not null,"
			    + "primary key (ID))";
		try {
			statement.execute(createAccountsTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createReservationsTable(Statement statement){
		String createReservationsTableQuery = "create table RESERVATION (ID integer not null GENERATED ALWAYS AS IDENTITY,"
				+ "CUSTOMERSURNAME varchar(50) not null,"
			    + "CUSTOMERNAME varchar(50) not null,"
			    + "CUSTOMERMIDDLENAME varchar(50) not null,"
			    + "CUSTOMERADDRESS varchar(50) not null,"
			    + "RESERVATIONDATE timestamp,"
			    + "PAYMENTDATE timestamp,"
			    + "primary key (ID))";

		try {
			statement.execute(createReservationsTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillFlightTable(Statement statement) {
		String flightFirstRow = "INSERT INTO FLIGHT (CREATIONDATE, FLIGHTNUMBER, DEPARTURE, ARRIVAL, DEPARTUREDATE, ARRIVALDATE, TICKETNUMBER, TICKETPRICE)"
			    + "VALUES ('2013-12-01 10:00:14', 'PS-711', 'Kyiv', 'Stambul', '2013-12-24 06:40:00', '2013-12-24 08:40:00', 10, 1000)";
		String flightSecondRow = "INSERT INTO FLIGHT (CREATIONDATE, FLIGHTNUMBER, DEPARTURE, ARRIVAL, DEPARTUREDATE, ARRIVALDATE, TICKETNUMBER, TICKETPRICE)"
			    + "VALUES ('2013-12-01 10:20:00', 'AQ-021', 'Kyiv', 'Roma', '2013-12-25 10:20:00', '2013-12-25 12:10:00', 5, 1500)";
		String flightThirdRow = "INSERT INTO FLIGHT (CREATIONDATE, FLIGHTNUMBER, DEPARTURE, ARRIVAL, DEPARTUREDATE, ARRIVALDATE, TICKETNUMBER, TICKETPRICE)"
			    + "VALUES ('2013-12-01 10:30:14', 'TF-140', 'Kyiv', 'New York', '2013-12-28 14:35:00', '2013-12-28 23:55:00', 2, 2000)";
		try {
		statement.execute(flightFirstRow);
		statement.execute(flightSecondRow);
		statement.execute(flightThirdRow);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillReservationTable(Statement statement) {
		String reservationFirstRow = "INSERT INTO RESERVATION (CUSTOMERSURNAME, CUSTOMERNAME, CUSTOMERMIDDLENAME, CUSTOMERADDRESS, RESERVATIONDATE, PAYMENTDATE)"
				+ "VALUES ('Surname1', 'Name1', 'Middlename1', 'Address1', '2013-12-04 10:00:14', '2013-12-05 10:00:14')";
		String reservationSecondRow = "INSERT INTO RESERVATION (CUSTOMERSURNAME, CUSTOMERNAME, CUSTOMERMIDDLENAME, CUSTOMERADDRESS, RESERVATIONDATE, PAYMENTDATE)"
				+ "VALUES ('Surname2', 'Name2', 'Middlename2', 'Address2', '2013-12-05 10:00:14', '2013-12-06 10:00:14')";
		String reservationThirdRow = "INSERT INTO RESERVATION (CUSTOMERSURNAME, CUSTOMERNAME, CUSTOMERMIDDLENAME, CUSTOMERADDRESS, RESERVATIONDATE)"
				+ "VALUES ('Surname3', 'Name3', 'Middlename3', 'Address3', '2013-12-06 10:00:14')";
		try {
			statement.execute(reservationFirstRow);
			statement.execute(reservationSecondRow);
			statement.execute(reservationThirdRow);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    private static void fillTicketTable(Statement statement) {
		String firstFlightTickets = "INSERT INTO TICKET (FLIGHTID, STATUS, RESERVATIONID) VALUES (1, 2, 1),"
				+ "(1, 2, 1), (1, 1, 3), (1, 1, 3), (1, 0, null), (1, 0, null), (1, 0, null), (1, 0, null), (1, 0, null), (1, 0, null)";
		String secondFlightTickets = "INSERT INTO TICKET (FLIGHTID, STATUS, RESERVATIONID) VALUES (2, 2, 1),"
				+ "(2, 2, 2), (2, 1, 3), (2, 0, null), (2, 0, null)";
		String thirdFlightTickets = "INSERT INTO TICKET (FLIGHTID, STATUS, RESERVATIONID) VALUES (3, 2, 2),"
				+ "(3, 0, 2)";
		try {
			statement.execute(firstFlightTickets);
			statement.execute(secondFlightTickets);
			statement.execute(thirdFlightTickets);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private static void fillAccountTable(Statement statement) {

        String firstAccountRow = "INSERT INTO ACCOUNT (LOGIN, PASSWORD, USERSURNAME, USERNAME, USERMIDDLENAME, USERROLE, ISACTIVE) VALUES ('1stUserLogin', 'tempPassword', 'Surname1', 'Name1', 'Middlename1', 1, TRUE)";
        String secondAccountRow = "INSERT INTO ACCOUNT (LOGIN, PASSWORD, USERSURNAME, USERNAME, USERMIDDLENAME, USERROLE, ISACTIVE) VALUES ('2ndUserLogin', 'tempPassword', 'Surname2', 'Name2', 'Middlename2', 2, TRUE)";
        String thirdAccountRow = "INSERT INTO ACCOUNT (LOGIN, PASSWORD, USERSURNAME, USERNAME, USERMIDDLENAME, USERROLE, ISACTIVE) VALUES ('3dAccountLogin', 'tempPassword', 'Surname3', 'Name3', 'Middlename3', 3, TRUE)";
        try {
            statement.execute(firstAccountRow);
            statement.execute(secondAccountRow);
            statement.execute(thirdAccountRow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
