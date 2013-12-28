package com.kukushkin.booking.office.dao;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kukushkin.booking.office.entity.Ticket;

public interface TicketDao extends Dao<Ticket> {

    //TODO: can be removed. Update can be used instead of it.
	void updateTicketsStatus(Map<Integer, Status> ticketsToUpdate) throws SQLException;

	List<Ticket> deleteTicketsOfCanceledFlight(int flightId) throws SQLException;

    List<Ticket> removeSomeTicketsFromFlight(int flightId, int ticketsCount) throws SQLException;

	List<Ticket> selectByConditions(Date startDate, Date endDate, String destination) throws SQLException;

    boolean hasFreeTickets(int flightId, int ticketCount);

    List<Ticket> getExpiredTickets();

    List<Ticket> getTicketsForReservation(int reservationId);

    public enum Status {FREE, BOOKED, SOLD}
}
