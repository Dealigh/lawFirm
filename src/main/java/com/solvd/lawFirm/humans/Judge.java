package com.solvd.lawFirm.humans;

public class Judge extends Human {

    private boolean belivesinJustice;

    public Judge(String nombre, int edad, boolean efficent, boolean belivesInJustice) {
        super(nombre, edad, efficent);
        this.belivesinJustice = belivesInJustice;

    }

    public String getProfession() {
        return "This person is a Judge. He has to resolve in problems between people impartially and make justice";
    }

    public boolean getJustice() {
        return this.belivesinJustice;
    }
}
