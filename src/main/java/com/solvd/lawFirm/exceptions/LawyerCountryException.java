package com.solvd.lawFirm.exceptions;

public class LawyerCountryException extends Exception{

    public LawyerCountryException() {
        super("The country of your lawyer and the one of the trials ARE NOT THE same. Select another Lawyer");
    }
}
