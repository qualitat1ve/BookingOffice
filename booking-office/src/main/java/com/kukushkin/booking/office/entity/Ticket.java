package com.kukushkin.booking.office.entity;

import com.kukushkin.booking.office.dao.TicketDao.Status;

import javax.persistence.*;

@Entity
public class Ticket implements Persistent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int flightId;
	private Status status;
    private int reservationId;


    public Ticket(int flightId) {
        this.flightId = flightId;
        status = Status.FREE;
    }

	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
    public int getReservationId() {
        return reservationId;
    }
    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
