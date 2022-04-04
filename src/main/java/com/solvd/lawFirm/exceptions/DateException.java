package com.solvd.lawFirm.exceptions;

public class DateException extends Exception{

    public DateException() {
        super("Not Valid DATE formal, we need a date to start the Trial");
    }

    public DateException(String message) { super(message);}
}
