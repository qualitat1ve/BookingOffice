package com.kukushkin.booking.office.dao;

import com.kukushkin.booking.office.entity.Ticket;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class TicketDaoTest extends BaseTest {
    private static TicketDaoImpl ticketDao;
    private int newTicketId;

    @BeforeClass
    public static void setUpBeforeClass() {
        ticketDao = new TicketDaoImpl();
    }

    @AfterClass
    public static void tearDownClass() {
        ticketDao = null;
    }

    @Test
    public void testRead() {
        Ticket ticket = null;
        ticket = ticketDao.read(1);
        assertTrue(ticket != null);
    }

    @Test
    public void testAdd() {
        Ticket ticket = new Ticket();
        ticket.setFlightId(2);
        ticket.setStatus(TicketDao.Status.BOOKED);
        ticket.setReservationId(2);
        ticketDao.add(ticket);
        newTicketId = ticket.getId();

        Ticket savedTicket = ticketDao.read(newTicketId);
        assertTrue(savedTicket != null);
        assertTrue(ticket.getFlightId() == savedTicket.getFlightId());
        assertTrue(ticket.getReservationId() == savedTicket.getReservationId());
        assertTrue(ticket.getStatus().ordinal() == savedTicket.getStatus().ordinal());
    }

    @Test
    public void testUpdate() {
        Ticket ticket = ticketDao.read(newTicketId);
        assertTrue(ticket != null);
        ticket.setStatus(TicketDao.Status.SOLD);
        ticketDao.update(ticket);
        Ticket updatedTicket = ticketDao.read(newTicketId);
        assertTrue(updatedTicket.getStatus() == TicketDao.Status.SOLD);
    }

    @Test
    public void testDelete() {
        Ticket ticket = ticketDao.read(newTicketId);
        assertTrue(ticket != null);
        ticketDao.delete(ticket.getId());
        Ticket deletedTicket = ticketDao.read(newTicketId);
        assertTrue(deletedTicket == null);
    }

    @Test
    public void testGetTicketsOfReservation() {
        //3
        int reservationId = 1;
        List<Ticket> list = ticketDao.getTicketsForReservation(1);
        assertTrue(list.size() == 3);
    }

    @Test
    public void testGetExpiredTickets() {
        //9
        List<Ticket> expiredTickets = ticketDao.getExpiredTickets();
        assertTrue(expiredTickets.size() == 9);
    }

    @Test
    public void testRemoveSomeTicketsFromFlight() {
        List<Ticket> deletedTickets = null;
        try {
            deletedTickets = ticketDao.removeSomeTicketsFromFlight(1, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Ticket removedTicket = deletedTickets.get(0);
        Ticket removedTicket2 = deletedTickets.get(1);
        assertTrue(removedTicket != null);
        assertTrue(removedTicket2 != null);
        assertTrue(removedTicket.getReservationId() == null);
        assertTrue(removedTicket2.getReservationId() == null);

        removedTicket = ticketDao.read(removedTicket.getId());
        removedTicket2 = ticketDao.read(removedTicket2.getId());

        assertTrue(removedTicket == null);
        assertTrue(removedTicket2 == null);
    }

}
