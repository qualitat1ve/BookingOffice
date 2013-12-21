package com.kukushkin.booking.office.dao;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kukushkin.booking.office.entity.Ticket;

public interface TicketDao extends Dao<Ticket> {
	void updateTicketsStatus(Map<Integer, Status> ticketsToUpdate) throws SQLException;
	void delete(int count) throws SQLException;
	List<Ticket> selectByConditions(Date startDate, Date endDate, String destination) throws SQLException;

    //TODO: Status can be used instead of int to set Ticket's status
    public enum Status {FREE, BOOKED, SOLD}
}
