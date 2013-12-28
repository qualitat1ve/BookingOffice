package com.kukushkin.booking.office.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestUtils {
    private static GregorianCalendar calendar;

    public static Calendar getCalendar() {
        return calendar = new GregorianCalendar();
    }

    public static Calendar createCalendarAndSetDate(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
        return calendar;
    }
}
