package com.solvd.lawFirm.resources;

public enum CountryName {
    ARGENTINA("Argentina"),
    BELARUS("Belarus"),
    UNITED_STATES("United States"),
    SPAIN("Spain"),
    ANOTHER("The Hague");

    private String countryName;

    CountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return this.countryName;
    }
}
