package com.solvd.lawFirm.person;

public class CommonPeople extends Person {
    private int moneyInPocket = 55000;
    private String countryOfResidence;

    public CommonPeople(String name) {
        super(name, 25, false);
    }

    public String getProfession() {
        return "This person works a lot.";
    }

    public void setEmbargo() {
        moneyInPocket -= 20000;
    }

    public int getMoneyInPocket() {
        return this.moneyInPocket;
    }

    public String getCountryOfResidence() {
        return this.countryOfResidence;
    }

    public void setCountryOfResidence(String Country) {
        this.countryOfResidence = Country;
    }

    public String getRole() { return "He is the ACCUSED"; };
}
