package com.solvd.lawFirm.resources;

import com.solvd.lawFirm.exceptions.AgeException;
import com.solvd.lawFirm.exceptions.LawyerCountryException;
import com.solvd.lawFirm.exceptions.NameException;
import com.solvd.lawFirm.trials.IPriceProcedure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.function.Supplier;

public class Resources {
    private static final Logger LOGG = LogManager.getLogger(Resources.class);
    Scanner sc = new Scanner(System.in);
    Scanner Sc = new Scanner(System.in);
    private String temporalStore;
    private int ageCheck;

    public String getJudgeProsecutor(String Judge, String Prosecutor) {
        return ("The judge will be: " + Judge + ".\n" + " The prosecutor will be: " + Prosecutor);
    }

    public <T> String getCourtJudge(T[] a) {
        return "This court has " + a.length + " judges";
    }

    public int readInt() throws AgeException {
        try {
            ageCheck = sc.nextInt();
            checkAge(ageCheck);

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Not an INT value");
        } catch (AgeException e) {
            throw new AgeException("Error. Can't initialize a trial with less than 18 years old");
        }
        return ageCheck;
    }

    static void checkAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException("\n" + "You must be 18+ to start a trial");
        }
    }

    public String setPartName() throws NameException {
        temporalStore = Sc.nextLine().toUpperCase();
        checkName();
        return temporalStore;
    }

    public void checkName() throws NameException {
        if (!temporalStore.matches("^[a-zA-Z]+$")) {
            throw new NameException("Name not valid. Non-alphabetic characters and numbers NOT allowed" + temporalStore);
        }
    }

    public String setJudgeName() {
        ageCheck = (int) (Math.random() * 100);
        if (ageCheck >= 90) {
            return "Carlos Fernandez";
        } else if (ageCheck >= 80) {
            return "William Lahbs";
        } else if (ageCheck >= 70) {
            return "Oliver Queen";
        } else if (ageCheck >= 60) {
            return "Edward Folly";
        } else if (ageCheck >= 50) {
            return "Joe Schultz";
        } else if (ageCheck >= 40) {
            return "Mike Kennedy";
        } else if (ageCheck >= 30) {
            return "Sonia Vera";
        } else if (ageCheck >= 20) {
            return "Carl Pismeni";
        } else {
            return "Olga Frank";
        }
    }

    public int setJudgeAge() {
        return ((int) (Math.random() * 50));
    }

    public boolean setBoolean() {
        Random rd = new Random();
        return rd.nextBoolean();
    }

    public boolean setDecition(boolean efficient, boolean belivesInJustice) {
        if (efficient && belivesInJustice) {
            return true;
        } else if (!efficient && !belivesInJustice) {
            return false;
        } else {
            return setBoolean();
        }
    }

    public String setProceedings(Integer age, Integer priceProcedure) {
        return age.toString() + priceProcedure.toString();
    }

    public String menuOptions() {
        Menu[] options = Menu.values();
        LOGG.info("Please press the number if you are here for: ");
        for (Menu o : options) {
            LOGG.info((o.ordinal() + 1) + ") " + o.name().toUpperCase().replace("_", " "));
        }
        return "";
    }

    public static void getCountryTrial(String countryName, String countryLawyerNme) throws LawyerCountryException {
        if (countryName.equals("The Hague")) {
            return;
        } else if (!countryName.equals(countryLawyerNme)) {
            throw new LawyerCountryException();
        }
    }

    public int getSumPrices(int x, int y) {
        IPriceProcedure op = (n1, n2) -> n1 + n2;
        return op.sumPrice(x, y);
    }

}
