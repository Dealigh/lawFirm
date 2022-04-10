package com.solvd.lawFirm.profession;

public class Teacher{
    private double salary;

    public Teacher() {
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
