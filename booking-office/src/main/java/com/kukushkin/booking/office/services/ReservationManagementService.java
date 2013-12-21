package com.kukushkin.booking.office.services;

import com.kukushkin.booking.office.dao.ReservationDao;
import com.kukushkin.booking.office.entity.Reservation;

import java.sql.SQLException;


public class ReservationManagementService {
    private ReservationDao reservationDao;

    public void createReservation(Reservation reservation){
        try {
            reservationDao.add(reservation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void acceptPayment(Reservation reservation) {
        try {
            reservationDao.update(reservation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
