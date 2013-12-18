package com.kukushkin.booking.office.entity;

import javax.persistence.*;

@Entity
public class Account implements Persistent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String loggin;
	private int password;
	private String userName;
	private String userSurname;
	private String userMiddlename;
	private int userRole;
	
	public Account() {}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getLoggin() {
		return loggin;
	}

	public void setLoggin(String loggin) {
		this.loggin = loggin;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserMiddlename() {
		return userMiddlename;
	}

	public void setUserMiddlename(String userMiddlename) {
		this.userMiddlename = userMiddlename;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
}
