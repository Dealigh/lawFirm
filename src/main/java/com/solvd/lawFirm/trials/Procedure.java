package com.solvd.lawFirm.trials;

import com.solvd.lawFirm.humans.Judge;

public abstract class Procedure {

	private int priceProcedure;
	private String part1, part2;
	private Judge judge;
	

	private int timeSpent = 12;

	public Procedure(String part1, String part2, int price) {
		this.part1 = part1;
		this.part2 = part2;
		this.priceProcedure = price;
	}

	public void setTimeSpent(int months) {
		timeSpent += months;
	}

	public String getTimeSpent() {
		return "Usually, a procedure take almost " + timeSpent + " months";
	}

	public String getExplanation() {
		return "Every trial has two parts confront with eachother and a Judge, that has to make a decisition.";
	}

	public abstract String getDetailedExplanation();

	public abstract int getPriceProcedure();

	public void setTrialJudge(Judge Judges) {
		this.judge = Judges;
	}

	public String getJudge() {
		return "We got the Judge: " + judge;
	}
	
	public abstract String setResolution(boolean Decition);

	public int setTotalPrice(int priceConsult, int priceProcedure) {
		return priceConsult + priceProcedure;
	}
	
	public int getTotalPrice() {
		return priceProcedure;
	}
}
