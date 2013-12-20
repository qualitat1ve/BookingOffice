package com.kukushkin.booking.office.dao;

import java.sql.SQLException;
import java.util.List;

import com.kukushkin.booking.office.entity.Reservation;

public interface ReservationDao extends Dao<Reservation> {
	List<Reservation> findExpired() throws SQLException;
	List<Reservation> findById(int id) throws SQLException;
}
