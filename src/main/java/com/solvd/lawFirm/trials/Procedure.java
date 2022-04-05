package com.solvd.lawFirm.trials;

public abstract class Procedure {

	private int priceProcedure;
	private String part1, part2;
	
	private int timeSpent = 768;

	public Procedure(String part1, String part2, int price) {
		this.part1 = part1;
		this.part2 = part2;
		this.priceProcedure = price;
	}


	public int getTimeSpent() { return timeSpent;}

	public String timeDescription() {
		return "This Trial usually takes: ";
	}

	public abstract String getDetailedExplanation();

	public abstract int getPriceProcedure();

	public String getJudge() {return "The name of the judge is: ";}
	
	public abstract String setResolution(boolean Decition);
}
