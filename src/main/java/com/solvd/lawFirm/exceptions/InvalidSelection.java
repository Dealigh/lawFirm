package com.solvd.lawFirm.exceptions;

public class InvalidSelection extends RuntimeException{

    public InvalidSelection() {
        super("Invalid Selection, press the numbers in the list for a Trial.");
    }
}
