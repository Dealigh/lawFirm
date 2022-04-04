package com.solvd.lawFirm.person;

public class Lawyers extends Person {

	public Lawyers(String nom, int edad, boolean efficent) {
		super(nom, edad, efficent);

	}

	public String getProfession() {
		return "This person is a lawyer. If there is a trial he has to defend you.";
	}
}
