package com.solvd.lawFirm.person;

public class Client extends Person {
	private int moneyOwned = 45000;

	public Client(String nombre) {
		super(nombre, 25, false);

	}

	public String getProfession() {
		return "This person works a lot.";
	}

	public void setMoneyOwned(int money) {
		this.moneyOwned -= money;
	}

	public String getMoneyOwned() {
		return "We have taken money from your bank account. Now you have: " + moneyOwned;
	}

	public String getRole() { return "He is our CLIENT"; };
}