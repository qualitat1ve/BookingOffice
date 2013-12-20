package com.kukushkin.booking.office.dao;

import java.sql.SQLException;

import com.kukushkin.booking.office.entity.Persistent;

public interface Dao<T extends Persistent> {
	
	void add(T persistent) throws SQLException;
	void update(T persistent) throws SQLException;
	void delete(int id) throws SQLException;
	void delete(T persistent) throws SQLException;
}
