package com.kukushkin.booking.office.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kukushkin.booking.office.entity.Ticket;

public class TicketDaoImpl extends BaseDao<Ticket> implements TicketDao {

    @Override
    public void updateTicketsStatus(Map<Integer, Status> ticketsToUpdate) throws SQLException {
        getEntityManger().getTransaction().begin();
        for (int key : ticketsToUpdate.keySet()) {
            Ticket ticket = read(key);
            ticket.setStatus(ticketsToUpdate.get(key));
            update(ticket);
        }
        getEntityManger().getTransaction().commit();
    }

    @Override
	public List<Ticket> selectByConditions(Date startDate, Date endDate, String destination) throws SQLException {
        //TODO: String query = "SELECT t FROM Ticket f WHERE t.startDate >= ?1 and t.endDate <= ?2 and ";
		return null;
	}

    @Override
    protected Class<Ticket> getRealClass() {
        return Ticket.class;
    }
}
