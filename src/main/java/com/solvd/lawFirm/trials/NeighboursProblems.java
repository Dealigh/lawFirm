package com.solvd.lawFirm.trials;

import com.solvd.lawFirm.laws.ILawCivil;
import com.solvd.lawFirm.laws.IMoney;

public class NeighboursProblems extends Procedure implements IMoney, ILawCivil {

	public NeighboursProblems(String part1, String part2) {
		super(part1, part2, 8000);
	}

	public String getDetailedExplanation() {
		return "IN this trial, you can resolve a problem you had when buying or selling anything, or a problem when something hasn't been used as intended or there is problems"
				+ " with legal relations that it comes with contracts";
	}

	public int getPriceProcedure() {
		return 8000;
	}
	
	public String getArbiter() {
		return "This type of trial can ve resolved with an Arbiter. They do not have power to decide, but rather help people to overcome their problems and reach to an agreement";
	}

	public String setResolution(boolean decition) {
		if(decition == true) {
			return "You win the Trial.";
		} else {
			return "You lost the Trial. Don't cause any more troubles to your neighbour";
		}
	}
	
	public String getMoneyOwned() {
		return "This Person has money at disposal: ";
	}
	
	public String getPriceConsult() {
		return "The price of the consult is " + priceConsult + "and the cost of the trial is " + priceProcedure;
	}

	public String getEmbargo() {
		return "We just made an Embargo over his goods, he cant sell anything and judge has at disposal $20000 to secure.";
	}
}
