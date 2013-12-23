package com.kukushkin.booking.office.dao;

import com.kukushkin.booking.office.entity.Reservation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class ReservationDaoTest extends BaseTest {

    private static ReservationDaoImpl reservationDao;
    private int newReservationId;

    @BeforeClass
    public static void  setUpBeforeClass() {
        reservationDao = new ReservationDaoImpl();
    }

    @AfterClass
    public static void tearDownClass() {
        reservationDao = null;
    }

    @Test
    public void testRead() {
        Reservation reservation = reservationDao.read(1);
        assertTrue(reservation != null);
    }

    @Test
    public void testAdd() {
        Reservation reservation = new Reservation();
        reservation.setCustomerAddress("testAddressCustomerOne");
        reservation.setCustomerMiddlename("testMiddlenameCustomerOne");
        reservation.setCustomerName("testNameCustomerOne");
        reservation.setCustomerSurname("testSurnameCustomerOne");
        reservation.setReservationDate(new Timestamp(TestUtils.getCalendar().getTime().getTime()));
        reservation.setPaymentDate(new Timestamp(TestUtils.getCalendar().getTime().getTime()));
        reservationDao.add(reservation);
        newReservationId = reservation.getId();

        Reservation savedReservation = reservationDao.read(newReservationId);
        assertTrue(savedReservation != null);
        assertTrue(reservation.getCustomerAddress().equals(savedReservation.getCustomerAddress()));
        assertTrue(reservation.getCustomerMiddlename().equals(savedReservation.getCustomerMiddlename()));
        assertTrue(reservation.getCustomerName().equals(savedReservation.getCustomerName()));
        assertTrue(reservation.getCustomerSurname().equals(savedReservation.getCustomerSurname()));
    }

    @Test
    public void testUpdate() {
        Reservation reservation = reservationDao.read(newReservationId);
        assertTrue(reservation != null);
        String newCustomerName = "testUpdateCustomerName";
        reservation.setCustomerName(newCustomerName);
        reservationDao.update(reservation);
        Reservation updatedReservation = reservationDao.read(reservation.getId());
        assertTrue(newCustomerName.equals(updatedReservation.getCustomerName()));
    }

    @Test
    public void testDelete() {
        Reservation reservation = reservationDao.read(newReservationId);
        assertTrue(reservation != null);
        reservationDao.delete(reservation);
        Reservation deletedReservation = reservationDao.read(reservation.getId());
        assertTrue(deletedReservation == null);
    }

    @Test
    public void testFindExpired() {
        //1
        List<Reservation> expiredReservations = null;
        try {
            expiredReservations = reservationDao.findExpired();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(expiredReservations.size() == 1);
    }
    @Test
    public void testFindNonExpired() {
        List<Reservation> nonExpiredReservations = null;
        try {
            nonExpiredReservations = reservationDao.findNonExpired();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(nonExpiredReservations.size() == 2);
    }

}
