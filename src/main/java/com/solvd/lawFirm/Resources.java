package com.solvd.lawFirm;

import com.solvd.lawFirm.exceptions.AgeException;
import com.solvd.lawFirm.exceptions.NameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Resources {
    private static final Logger LOGG = LogManager.getLogger(Resources.class);
    Scanner sc = new Scanner(System.in);
    Scanner Sc = new Scanner(System.in);
    private String temporalStore;
    private int age;

    public <T, V> void getJudgeProsecutor(T Judge, V Prosecutor) {
        LOGG.info("The judge will be: " + Judge);
        LOGG.info("The prosecutor will be: " + Prosecutor);
    }

    public <T> String getCourtJudge(T[]a) {
        return "This court has " + a.length + " judges";
    }

    public int readInt()throws AgeException{
        try {
            age = sc.nextInt();
            checkAge(age);

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Not an INT value");
        } catch (AgeException e) {
            throw new AgeException("Error. Can't initialize a trial with less than 18 years old");
        }
        return age;
    }

    static void checkAge(int age) throws AgeException {
        if(age<18) {
            throw new AgeException("\n" + "You must be 18+ to start a trial");
        }
    }

    public String setPartName() throws NameException {
        temporalStore = Sc.nextLine().toUpperCase();
        checkName();
        return temporalStore;
    }

    public void checkName() throws NameException{

        if (!temporalStore.matches("^[a-zA-Z]+$")) {
            throw new NameException("Name not valid. Non-alphabetic characters and numbers NOT allowed" + temporalStore);
        }

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
        LOGG.info("Please press the number if you are here for: ");
        LOGG.info("1- A divorce");
        LOGG.info("2- A Labor Lawsuit");
        LOGG.info("3- A Problem with Neighbours");
        LOGG.info("4- A Trade");
        LOGG.info("5- A Criminal Offence");
        return "";
    }

}

