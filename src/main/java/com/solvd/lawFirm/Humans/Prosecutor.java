package com.solvd.lawFirm.Humans;

public class Prosecutor extends Human {
    private boolean belivesinJustice = true;

    public Prosecutor(String nombre, int edad, boolean efficent) {
        super(nombre, edad, efficent);

    }

    public String getProfession() {
        return "This person is an Prosecutor. His job is to put people behind bars.";
    }
}