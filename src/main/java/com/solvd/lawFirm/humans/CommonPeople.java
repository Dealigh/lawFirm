package com.solvd.lawFirm.humans;

public class CommonPeople extends Human {
	private int MoneyInPocket = 55000;


	public CommonPeople(String nombre) {
		super(nombre, 25, false);

	}

	public String getProfession() {
		return "This person works a lot.";
	}

	public void setEmbargo() {
		MoneyInPocket -= 20000;
	}

	public int getMoneyInPocket() {
		return this.MoneyInPocket;
	}
}
