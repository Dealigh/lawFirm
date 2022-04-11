package com.solvd.lawFirm.resources;

import com.solvd.lawFirm.exceptions.DateException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time {

    public static Calendar calendar = new GregorianCalendar();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd, MMM yyyy");
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

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
                DaysOfWeek day = DaysOfWeek.SUNDAY;
                return day.toString();
            case 2:
                DaysOfWeek day1 = DaysOfWeek.MONDAY;
                return day1.toString();
            case 3:
                DaysOfWeek day2 = DaysOfWeek.TUESDAY;
                return day2.toString();
            case 4:
                DaysOfWeek day3 = DaysOfWeek.WEDNESDAY;
                return day3.toString();
            case 5:
                DaysOfWeek day4 = DaysOfWeek.THURSDAY;
                return day4.toString();
            case 6:
                DaysOfWeek day5 = DaysOfWeek.FRIDAY;
                return day5.toString();
            case 7:
                DaysOfWeek day6 = DaysOfWeek.SATURDAY;
                return day6.toString();
            default:
                return "";
        }
    }

    public static Date stringToDate(String date) throws DateException {

        try {
            return sdf2.parse(date);
        } catch (Exception e) {
            throw new DateException(e.getMessage());
        }
    }

    public static int daySt = calendar.get(Calendar.DAY_OF_WEEK);
    public static int day = calendar.get(Calendar.DAY_OF_MONTH);
    public static int year = calendar.get(Calendar.YEAR);
    public static int month = calendar.get(Calendar.MONTH);

}