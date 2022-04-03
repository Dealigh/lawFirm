package com.solvd.lawFirm.trials;

import com.solvd.lawFirm.humans.Judge;

public abstract class Procedure {

	private int priceProcedure;
	private String part1, part2;
	
	private int timeSpent = 768;

	public Procedure(String part1, String part2, int price) {
		this.part1 = part1;
		this.part2 = part2;
		this.priceProcedure = price;
	}

	public void setTimeSpent(int days) {
		timeSpent = timeSpent + days;
	}

	public int getTimeSpent() { return timeSpent;}

	public String getExplanation() {
		return "Every trial has two parts confront with each other and a Judge, that has to make a decisition.";
	}
	public String timeDescription() {
		return "This Trial usually takes: ";
	}

	public abstract String getDetailedExplanation();

	public abstract int getPriceProcedure();

	public static String getJudge() {return "The name of the judge is: ";}
	
	public abstract String setResolution(boolean Decition);

	public int setTotalPrice(int priceConsult, int priceProcedure) {
		return priceConsult + priceProcedure;
	}
	
	public int getTotalPrice() {
		return priceProcedure;
	}
}
