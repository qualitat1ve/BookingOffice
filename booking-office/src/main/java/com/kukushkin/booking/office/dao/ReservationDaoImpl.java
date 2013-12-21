package com.kukushkin.booking.office.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.kukushkin.booking.office.entity.Reservation;

import javax.persistence.TypedQuery;

public class ReservationDaoImpl extends BaseDao<Reservation> implements ReservationDao {

	@Override
	public List<Reservation> findExpired() throws SQLException {
        String query = "SELECT r FROM Reservation r WHERE r.reservationDate BEFORE ?1";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -3);
        Date deadLine = new Date(calendar.getTime().getTime());
        List<Reservation> reservationList = null;
        TypedQuery<Reservation> typedQuery = getEntityManger().createQuery(query, Reservation.class);
        try {
            typedQuery.setParameter(1, deadLine);
            reservationList = typedQuery.getResultList();
        }
        finally {
            getEntityManger().close();
        }
        return reservationList;
	}

    @Override
    protected Class<Reservation> getRealClass() {
        return Reservation.class;
    }
}
