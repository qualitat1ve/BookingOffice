package com.kukushkin.booking.office.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.kukushkin.booking.office.entity.Ticket;

public class TicketDaoImpl extends BaseDao<Ticket> implements TicketDao {

	@Override
	public void add(Ticket persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ticket persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Ticket persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTicketsStatus(int... ticketsId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ticket> selectByConditions(Date startDate, Date endDate, String destination) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
