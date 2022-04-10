package com.solvd.lawFirm.person;

import com.solvd.lawFirm.Consult;
import com.solvd.lawFirm.CountryName;
import com.solvd.lawFirm.exceptions.NameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Country extends Person {

    private static final Logger LOGGER = LogManager.getLogger(Consult.class);
    Scanner sc = new Scanner(System.in);

    public Country(String name, int age, boolean efficient) {
        super(name, age, efficient);
    }

    @Override
    public String getProfession() {
        return "A country is, by definition, a fictional person. It has all the benefits and obligations that humans and companies does, by rule of law";
    }

    public String getCountriesAvailable() {
        CountryName[] countries = CountryName.values();
        LOGGER.info("Chose a country, if it doesn't appear on the list chose other");
        for (CountryName c: countries) {
            LOGGER.info((c.ordinal()+ 1) + ") "+ c.name().toUpperCase());
        }
        return countries[(sc.nextInt() - 1)].toString();
    }

    public Country getCountry(String countryName) throws NameException {
        Country argentina = new Country("Argentina", 212, false);
        Country belarus = new Country("Belarus", 31, true);
        Country unitedStates = new Country("United States", 241, true);
        Country spain = new Country("Spain", 530, true);
        Country hague = new Country("The Hague", 77, true);

        if (countryName.equals("ARGENTINA")) {
            return argentina;
        } else if (countryName.equals("BELARUS")) {
            return belarus;
        } else if (countryName.equals("UNITEDSTATES")) {
            return unitedStates;
        } else if (countryName.equals("SPAIN")) {
            return spain;
        } else if (!countryName.matches("^[a-zA-Z]+$")) {
            throw new NameException("Name of the Country NOT VALID.");
        } else {
            return hague;
        }
    }

    public Object setCourtCountry(String secondPartCountry, String clientCountry) throws NameException {
        if (secondPartCountry.equals(clientCountry.toUpperCase())) {
            LOGGER.info("Let's Proceed");
            return getCountry(clientCountry);
        } else {
            LOGGER.info("You are not from the same country, so this trial will take Place on The Hague, the international court");
            return getCountry(secondPartCountry);
        }
    }

    public String getRole() { return "This is a country."; };
}
