package com.solvd.lawFirm;

import com.solvd.lawFirm.exceptions.DateException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time {

    public static Calendar calendar = new GregorianCalendar();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd, MMM yyyy");


    public static Date actualDate = new Date();
    public static final String todayDate = dateToString(actualDate);

    public static String getDate() {
        return getNameDay(daySt) +" " + todayDate;
    }

    public static String dateToString(Date date) {
        return sdf.format(date);
    }

    public static String getMoreDays(int moreDays) {
        calendar.set(year, month, day + moreDays);
        Date days = calendar.getTime();
        return dateToString(days);
    }

    public static String getNameDay(int daySt) {
        switch(daySt) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return "";
        }
    }

    public static Date stringToDate(String date) throws DateException {
        Date userDate = null;
        try {
            userDate = sdf.parse(date);
            return userDate;
        } catch (Exception e) {
            throw new DateException(e.getMessage());
        }
    }

    public static int daySt = calendar.get(Calendar.DAY_OF_WEEK);
    public static int day = calendar.get(Calendar.DAY_OF_MONTH);
    public static int year = calendar.get(Calendar.YEAR);
    public static int month = calendar.get(Calendar.MONTH);

}

/*
    Date year = calen.getTime();
    int anio = calen.get(Calendar.YEAR);
    int month = calen.get(Calendar.MONTH) + 1;
    int day = calen.get(Calendar.DAY_OF_MONTH);
    int daySt = calen.get(Calendar.DAY_OF_WEEK);
    */
