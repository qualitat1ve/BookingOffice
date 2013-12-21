package com.kukushkin.booking.office.dao;

import java.sql.SQLException;
import java.util.List;

import com.kukushkin.booking.office.entity.Reservation;

public class ReservationDaoImpl extends BaseDao<Reservation> implements ReservationDao {

	@Override
	public List<Reservation> findExpired() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    protected Class<Reservation> getRealClass() {
        return Reservation.class;
    }
}
