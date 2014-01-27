package com.kukushkin.booking.office.entity;

import javax.persistence.*;

@Entity
public class Account implements Persistent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	private String userName;
	private String userSurname;
	private String userMiddleName;
	private int userRole;
    private boolean isFrozen;
    public static final String INACTIVE_ACCOUNT_STATUS = "Inactive";
	
	public Account(String login) {
        this.login = login;
        password = login;
    }
	
	public Account() {}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
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

	public String getUserMiddleName() {
		return userMiddleName;
	}

	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean isActive) {
        this.isFrozen = isActive;
    }
}
