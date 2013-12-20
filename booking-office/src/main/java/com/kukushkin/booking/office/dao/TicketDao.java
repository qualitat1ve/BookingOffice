package com.kukushkin.booking.office.dao;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.kukushkin.booking.office.entity.Ticket;

public interface TicketDao extends Dao<Ticket> {
	
	void updateTicketsStatus(int...ticketsId) throws SQLException;
	void delete(int count) throws SQLException;
	List<Ticket> selectByConditions(Date startDate, Date endDate, String destination) throws SQLException;
}
