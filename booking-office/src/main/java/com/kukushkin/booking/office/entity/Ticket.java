package com.kukushkin.booking.office.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Ticket implements Persistent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int flightId;
	private int status;
	private Date reservationDate;
	private Date paymentDate;
	
	public Ticket() {}
	
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
