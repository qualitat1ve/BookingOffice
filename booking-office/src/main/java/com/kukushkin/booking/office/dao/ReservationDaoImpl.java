package com.kukushkin.booking.office.dao;

import java.sql.SQLException;
import java.util.List;

import com.kukushkin.booking.office.entity.Reservation;

import javax.persistence.TypedQuery;

public class ReservationDaoImpl extends BaseDao<Reservation> implements ReservationDao {


    //TODO: refactor (1 method with parameter!)


	@Override
	public List<Reservation> findExpired() throws SQLException {
		String query = "SELECT r FROM Reservation r WHERE r.reservationDate < ?1 and r.paymentDate=null";
		List<Reservation> reservationList = null;
		TypedQuery<Reservation> typedQuery = getEntityManger().createQuery(query, Reservation.class);
		typedQuery.setParameter(1, getDeadlineDate());
		reservationList = typedQuery.getResultList();
		return reservationList;
	}

    @Override
    public List<Reservation> findNonExpired() throws SQLException {
        String query = "Select r FROM Reservation r WHERE r.reservationDate > ?1";
        List<Reservation> reservationList = null;
        TypedQuery<Reservation> typedQuery = getEntityManger().createQuery(query, Reservation.class);
        typedQuery.setParameter(1, getDeadlineDate());
        reservationList = typedQuery.getResultList();
       
        return reservationList;
    }

    @Override
    protected Class<Reservation> getRealClass() {
        return Reservation.class;
    }
}
