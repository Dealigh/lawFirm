package com.solvd.lawFirm.person;

public class Prosecutor extends Person {

    public Prosecutor(String nombre, int edad, boolean efficent) {
        super(nombre, edad, efficent);

    }

    public String getProfession() {
        return "This person is an Prosecutor. His job is to put people behind bars.";
    }
}