package com.solvd.lawFirm.profession;

public class Cop{
    private String definition = " is a Cop";
    private double salary;

    public Cop() {
        this.salary = 25081.25;
    }

    public double getSalary() {
        return salary;
    }

    public String getDefinitionWork() {
        return definition;
    }
}
