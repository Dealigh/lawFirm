package com.solvd.lawFirm.person.profession;

import com.solvd.lawFirm.resources.Consult;
import com.solvd.lawFirm.person.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Profession<T extends Person> {
    private static final Logger LOGGER = LogManager.getLogger(Consult.class);
    Scanner sc = new Scanner(System.in);
    private T referencePerson;
    private double salary;
    private String profession;
    private String election;

    public Profession(T person) {
        this.referencePerson = person;
        this.profession = setProfession();
        this.salary = setSalary();
    }

    public double getSalary() {
        return salary;
    }

    public String getProfession() {
        return profession;
    }

    private double setSalaryLambda(Integer x) {
        ISalary getSalary = (s) -> 512.25 * s;
        this.salary = getSalary.declareSalary(x);
        return salary;
    }

    private String setProfession() {
        Jobs[] jobs = Jobs.values();
        LOGGER.info("It can be: ");
        for (Jobs j : jobs) {
            LOGGER.info((j.ordinal() + 1) + ") " + j.name().toUpperCase());
        }
        election = jobs[sc.nextInt() - 1].toString();
        return election;
    }

    private double setSalary() {
        Jobs jobs = Enum.valueOf(Jobs.class, election);
        return setSalaryLambda(jobs.getUnitSalary());
    }
}
