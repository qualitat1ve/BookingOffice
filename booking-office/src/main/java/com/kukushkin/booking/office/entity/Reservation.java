package com.kukushkin.booking.office.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
public class Reservation implements Persistent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String customerSurname;
	private String customerName;
	private String customerMiddlename;
	private String customerAddress;
	private Timestamp reservationDate;
	private Timestamp paymentDate;
	
	public Reservation() {
        reservationDate = new Timestamp(new java.util.Date().getTime());
    }
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCustomerSurname() {
		return customerSurname;
	}
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMiddlename() {
		return customerMiddlename;
	}
	public void setCustomerMiddlename(String customerMiddlename) {
		this.customerMiddlename = customerMiddlename;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public Timestamp getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Timestamp reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
}
