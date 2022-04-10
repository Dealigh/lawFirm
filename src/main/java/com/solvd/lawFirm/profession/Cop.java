package com.solvd.lawFirm.profession;

public class Cop{
    private double salary;

    public Cop() {
        this.salary = setSalaryLambda();
    }

    public double getSalary() {
        return salary;
    }

    public double setSalaryLambda(){
        ISalary getSalary = (s) -> 512.25 * s;
        return getSalary.declareSalary(2.3);
    }
}
