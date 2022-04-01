package com.solvd.lawFirm.trials;

import com.solvd.lawFirm.laws.LawLabor;
import com.solvd.lawFirm.laws.Money;

public class LaborLawsuit extends Procedure implements LawLabor, Money {

	public LaborLawsuit(String part1, String part2) {
		super(part1, part2, 20000);
	}

	public String getDetailedExplanation() {
		return "IN this trial, its to resolve legal confrontations based on employer-employee relations, and the inherit conditions from contracts between those two.";
	}

	public int getPriceProcedure() {
		return 13500;
	}
	
	public String setResolution(boolean decition) {
		if(decition == true) {
		return "You win the Trial. The employer has to pay to you what it is owed";
		} else {
		return "You lost the Trial. The employer doesn't have to pay you anything.";
		}
	}

	public String getPriceConsult() {
		return "The price of the consult is " + priceConsult + "and the cost of the trial is " + priceProcedure;
	}

	public String getEmbargo() {
		return "We just made an Embargo over his goods, he cant sell anything and judge has at disposal $20000 to secure.";
	}
	

	public String getMoneyOwned() {
		return "This Person has money and goods at disposal: ";
	}
}
