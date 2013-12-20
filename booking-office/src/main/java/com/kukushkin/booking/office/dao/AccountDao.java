package com.kukushkin.booking.office.dao;

import java.sql.SQLException;

import com.kukushkin.booking.office.entity.Account;

public interface AccountDao extends Dao<Account>{
	void setPermissions(int accountId, int role) throws SQLException;
	
	//TODO: Opportunity may be implemented in the future
	void addAdditionalPermissions(int accountId, int permissions) throws SQLException;
}
