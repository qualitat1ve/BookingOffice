package com.kukushkin.booking.office.entity;

import java.sql.Date;

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
	private Date reservationDate;
	private Date paymentDate;
	
	public Reservation() {
        reservationDate = new Date(new java.util.Date().getTime());
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
