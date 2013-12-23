package com.kukushkin.booking.office.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kukushkin.booking.office.entity.Ticket;

import javax.persistence.TypedQuery;

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
    public List<Ticket> deleteTicketsOfCanceledFlight(int flightId) throws SQLException {
       return removeSomeTicketsFromFlight(flightId, Integer.MAX_VALUE);
    }

    @Override
	public List<Ticket> removeSomeTicketsFromFlight(int flightId, int ticketsCount) throws SQLException {
		String query = "SELECT t FROM Ticket t, Flight f WHERE t.flightId = ?1 and t.status=?2";
		TypedQuery<Ticket> typedQuery = getEntityManger().createQuery(query, Ticket.class);
		List<Ticket> ticketList = null;
		typedQuery.setParameter(1, flightId);
        typedQuery.setParameter(2, Status.FREE);
		typedQuery.setMaxResults(ticketsCount);
		ticketList = typedQuery.getResultList();

		for (Ticket ticket : ticketList) {
			delete(ticket);
		}
        return ticketList;
	}

    @Override
	public List<Ticket> selectByConditions(Date startDate, Date endDate, String destination) throws SQLException {
        //TODO: String query = "SELECT t FROM Ticket f WHERE t.startDate >= ?1 and t.endDate <= ?2 and ";
		return null;
	}

    @Override
    public boolean hasFreeTickets(int flightId, int ticketCount) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Ticket> getExpiredTickets() {
        String query = "SELECT t FROM Ticket t, Reservation r where r.id = t.reservationId and r.reservationDate < ?1";
        List<Ticket> ticketsList = null;
		TypedQuery<Ticket> typedQuery = getEntityManger().createQuery(query, Ticket.class);
		typedQuery.setParameter(1, getDeadlineDate());
		ticketsList = typedQuery.getResultList();
		return ticketsList;
    }

    @Override
    public List<Ticket> getTicketsForReservation(int reservationId) {
        String query = "SELECT t FROM Ticket t WHERE t.reservationId = ?1";
        List<Ticket> ticketsList = null;
        TypedQuery<Ticket> typedQuery = getEntityManger().createQuery(query, Ticket.class);
        typedQuery.setParameter(1, reservationId);
        ticketsList = typedQuery.getResultList();
        return ticketsList;
    }


    @Override
    protected Class<Ticket> getRealClass() {
        return Ticket.class;
    }
}
