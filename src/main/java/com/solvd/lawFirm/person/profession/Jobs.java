package com.solvd.lawFirm.person.profession;

public enum Jobs {
    MEDIC(9),
    TEACHER(3),
    COP(4),
    CHEF(4);

    private Jobs(int unitSalary) {
        this.unitSalary = unitSalary;
    }

    public int getUnitSalary() {
        return unitSalary;
    }

    private int unitSalary;
}
