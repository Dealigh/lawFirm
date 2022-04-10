package com.solvd.lawFirm.profession;

import com.solvd.lawFirm.Consult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Profession {
    Scanner sc = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(Consult.class);

    private double salary;
    private String profession;
    private String election;

    public Profession() {
        this.profession = setProfession();
        this.salary = setSalary();
    }

    public double getSalary() {
        return salary;
    }

    public String getProfession() {
        return profession;
    }

    private double setSalaryLambda(Integer x){
        ISalary getSalary = (s) -> 512.25 * s;
        this.salary = getSalary.declareSalary(x);
        return salary;
    }

    private String setProfession() {
        Jobs[] jobs = Jobs.values();
        LOGGER.info("Please chose a profession, it can be: ");
        for (Jobs j: jobs) {
            LOGGER.info((j.ordinal()+ 1) + ") "+ j.name().toUpperCase());
        }
        election = jobs[sc.nextInt()-1].toString();
        return election;
    }

     private double setSalary() {
        Jobs jobs = Enum.valueOf(Jobs.class, election);
        return setSalaryLambda(jobs.getUnitSalary());
    }
}
