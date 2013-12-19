package com.kukushkin.booking.office.dao;


import java.sql.SQLException;

import com.kukushkin.booking.office.entity.Ticket;

public interface TicketDao extends Dao<Ticket> {
	
	void updateTicketsStatus(int...ticketsId) throws SQLException;
	void delete(int count) throws SQLException;
}
