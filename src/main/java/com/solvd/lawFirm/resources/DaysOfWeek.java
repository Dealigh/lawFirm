package com.solvd.lawFirm.resources;

public enum DaysOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String dayName;

    DaysOfWeek(String dayName) {
        this.dayName = dayName;
    }

    public String getDayName() {
        return this.dayName;
    }
}
