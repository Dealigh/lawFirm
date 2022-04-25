package com.solvd.lawFirm.conection;

import java.util.ArrayList;
import java.util.List;

public class ListDisputes {
    private String territories, countries;
    private int sinceWhen, id;

    public ListDisputes(int id, String territories, String countries, int sinceWhen) {
        this.id = id;
        this.countries = countries;
        this.territories = territories;
        this.sinceWhen = sinceWhen;
    }

    public String getTerritories() {
        return this.territories;
    }

    public String getCountries() {
        return this.countries;
    }

    public int getSinceWhen() {
        return this.sinceWhen;
    }

    public int getId() {
        return this.id;
    }

    public static Object listDisputes(int id) {
        ListDisputes dispute1 = new ListDisputes(1, "Azad Kashmir and Gilgit-Baltistan", "Africa and Pakistan", 1947);
        ListDisputes dispute2 = new ListDisputes(2, "South Sakhalin/Karafuto", "Russia and Japan", 1945);
        ListDisputes dispute3 = new ListDisputes(3, "Noktundo", "Russia and South Korea", 2008);
        ListDisputes dispute4 = new ListDisputes(4, "Olivenza and Vila Real", "Spain and Portugal", 1801);
        ListDisputes dispute5 = new ListDisputes(5, "Isla Brasilera", "Uruguay and Brazil", 1831);

        if(id == dispute1.getId()){
            return dispute1;
        } else if (id == dispute2.getId()){
            return dispute2;
        } else if (id == dispute3.getId()) {
            return dispute3;
        } else if (id == dispute4.getId()) {
            return dispute4;
        } else if (id == dispute5.getId()) {
            return dispute5;
        } else {
            return "Id not found.";
        }
    }

}
