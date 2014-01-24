package com.kukushkin.booking.office.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Flight implements Persistent, Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	private String flightNumber;
	private String departure;
	private String arrival;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
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
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
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
                (flight.getDeparture() != null && flight.getDeparture().equals(departure)) &&
                (flight.getCreationDate() != null && flight.getCreationDate().equals(creationDate));

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

    public String toString() {
        return flightNumber;
    }

}
