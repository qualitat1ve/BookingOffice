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
	
	
	public Ticket() {
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
