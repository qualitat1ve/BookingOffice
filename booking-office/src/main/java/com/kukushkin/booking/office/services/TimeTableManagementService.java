package com.kukushkin.booking.office.services;

import com.kukushkin.booking.office.dao.*;
import com.kukushkin.booking.office.entity.Flight;
import com.kukushkin.booking.office.entity.Reservation;
import com.kukushkin.booking.office.entity.Ticket;
import java.sql.SQLException;

public class TimeTableManagementService {

    private FlightDao flightDao;
    private TicketDao ticketDao;
    private ReservationDao reservationDao;

    public TimeTableManagementService() {
        flightDao = new FlightDaoImpl();
        ticketDao = new TicketDaoImpl();
        reservationDao = new ReservationDaoImpl();
    }

    public void addFlightToTimetable(Flight flight) {
        try {
            flightDao.add(flight);
            for (int i = 1; i <= flight.getTicketNumber(); i++) {
                Ticket ticket = new Ticket(flight.getId());
                ticketDao.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFlightFromTimeTable(int flightId) {
        try {
            flightDao.delete(flightId);
            ticketDao.deleteTicketsOfCanceledFlight(flightId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editFlightFromTimeTable(Flight flight) {
        try {
            int oldTicketsCount = flightDao.read(flight.getId()).getTicketNumber();
            int newTicketsCount = flight.getTicketNumber();
            int difference = oldTicketsCount - newTicketsCount;
            if (difference > 0) {
                for(int i = 0; i < difference; i++) {
                    Ticket ticket = new Ticket(flight.getId());
                    ticketDao.add(ticket);
                }
            } else if (difference < 0) {
                if (ticketDao.hasFreeTickets(flight.getId(), difference)) {
                    ticketDao.removeSomeTicketsFromFlight(flight.getId(), difference);
                } else {
                    //TODO: print message like:
                    throw new SQLException("Some tickets you are trying to delete are already sold or reserved!");
                }
            } else {
                //TODO: print message to monkey-administrator "There is no changes!"
            }
            flightDao.update(flight);
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateExpiredTickets() {
        try {
            for (Ticket ticket : ticketDao.getExpiredTickets()) {
                ticket.setStatus(TicketDao.Status.FREE);
                ticket.setReservationId(null);
                ticketDao.update(ticket);
            }
            for (Reservation reservation : reservationDao.findExpired()) {
                reservationDao.delete(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
