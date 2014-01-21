package com.kukushkin.booking.office.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Flight implements Persistent, Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Timestamp creationDate;
	private String flightNumber;
	private String departure;
	private String arrival;
	private Timestamp departureDate;
	private Timestamp arrivalDate;
	private int ticketNumber;
	private double ticketPrice;
	
	public Flight() {}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public Timestamp getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}
	public Timestamp getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

    public boolean equals(Object obj) {
        if (!(obj instanceof Flight)) return false;
        Flight flight = (Flight) obj;
        return (flight.getFlightNumber() != null && flight.getFlightNumber().equals(flightNumber)) &&
                (flight.getDeparture() != null && flight.getDeparture().equals(departure));

    }

    public int hashCode() {
        int hash = 1;
        if (flightNumber != null) {
            hash = hash * 31 + flightNumber.hashCode();
        }
        if (departure != null) {
            hash = hash * 29 + departure.hashCode();
        }
        return hash;
    }

}
