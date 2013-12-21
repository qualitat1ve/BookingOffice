package com.kukushkin.booking.office.dao;

import java.sql.SQLException;

import com.kukushkin.booking.office.entity.Persistent;

public interface Dao<T extends Persistent> {
	
	T add(T persistent) throws SQLException;
	T update(T persistent) throws SQLException;
	void delete(int id) throws SQLException;
	void delete(T persistent) throws SQLException;
    T read(int id) throws SQLException;
}
