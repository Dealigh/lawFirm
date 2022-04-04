package com.solvd.lawFirm.person;

public class Arbiter extends Person {

	public Arbiter(String nombre, int edad, boolean efficent) {
		super(nombre, edad, efficent);

	}

	public String getProfession() {
		return "This person is an Arbiter. He tries to resolve people's problem but has no autority to do so.";
	}
}
