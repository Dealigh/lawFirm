package com.solvd.lawFirm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class Resources {
    private static final Logger LOGG = LogManager.getLogger(Resources.class);
    Scanner sc = new Scanner(System.in);
    Scanner Sc = new Scanner(System.in);
    private String temporalStore;

    public static <T, V> void getJudgeProsecutor(T Judge, V Prosecutor) {
        System.out.println("The judge will be: " + Judge);
        System.out.println("The prosecutor will be: " + Prosecutor);
    }

    public static <T> String getCourtJudge(T[]a) {
        return "This court has " + a.length + " judges";
    }

    public int readInt() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Not an INT value");
        }
    }

    public String setPartName() {
        temporalStore = Sc.nextLine();
        if (!temporalStore.matches("^[a-zA-Z]+$")) {
            LOGG.warn("Name not valid. Non-alphabetic characters and numbers NOT allowed");
            System.exit(0);
        }
        return temporalStore;
    }

    public String setJudgeName() {
        if ((int) (Math.random() * 100) >= 90) {
            return "Carlos Fernandez";
        } else if ((int) (Math.random() * 100) >= 80) {
            return "William Lahbs";
        } else if ((int) (Math.random() * 100) >= 70) {
            return "Oliver Queen";
        } else if ((int) (Math.random() * 100) >= 60) {
            return "Edward Folly";
        } else if ((int) (Math.random() * 100) >= 50) {
            return "Joe Schultz";
        } else if ((int) (Math.random() * 100) >= 40) {
            return "Mike Kennedy";
        } else if ((int) (Math.random() * 100) >= 30) {
            return "Sonia Vera";
        } else if ((int) (Math.random() * 100) >= 20) {
            return "Carl Pismeni";
        } else {
            return "Olga Frank";
        }
    }

    public int setJudgeAge() {
        return ((int) (Math.random() * 50));
    }

    public boolean setBoolean() {
        if ((int) (Math.random() * 100) >= 50) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setDecition(boolean efficient, boolean belivesInJustice) {
        if (efficient == true && belivesInJustice == true) {

            return true;
        } else if (efficient == false && belivesInJustice == false) {
            return false;
        } else {
            return setBoolean();
        }
    }

    public String setProceedings(Integer Age, Integer priceProcedure) {
        return Age.toString() + priceProcedure.toString();
    }

    public String menuOptions() {
        System.out.println("Please press the number if you are here for: ");
        System.out.println("1- A divorce");
        System.out.println("2- A Labor Lawsuit");
        System.out.println("3- A Problem with Neighbours");
        System.out.println("4- A Trade");
        System.out.println("5- A Criminal Offence");
        return "";
    }
}

