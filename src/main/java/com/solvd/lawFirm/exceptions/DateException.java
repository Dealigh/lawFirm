package com.solvd.lawFirm.exceptions;

public class DateException extends Exception{

    public DateException() {
        super();
    }

    public DateException(String message) { super(message);}

    @Override
    public String getMessage() {
        return "Not Valid DATE formal, we need a date to start the Trial";
    }
}
