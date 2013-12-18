package com.kukushkin.booking.office.dao;

import com.kukushkin.booking.office.entity.Persistent;

public interface Dao<T extends Persistent> {
	
	void add(T persistent);
	void update(T persistent);
	void delete(int id);
	void delete(T persistent);

}
