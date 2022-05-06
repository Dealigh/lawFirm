package com.solvd.lawFirm.person;

public class Part<T extends Person> {

    private T part;

    public Part(T part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "Name: " + part.getName() + "\n" + "Age: " + part.getAge() + "\n" + "And in this trial his role is: " + part.getRole() + "\n"
                + "His profession its: " + part.getProfession() + "\n";
    }
}

