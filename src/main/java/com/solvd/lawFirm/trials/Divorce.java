package com.solvd.lawFirm.trials;

import com.solvd.lawFirm.laws.iLawDivorce;
import com.solvd.lawFirm.laws.IMoney;

public class Divorce extends Procedure implements iLawDivorce, IMoney {
	
	public Divorce(String part1, String part2) {
		super(part1, part2, priceProcedure);
	}

	public String getDetailedExplanation() {
		return "IN this trial, u will be confronting ur soon to be ex-wife, to divide the goods you two got while married.";
	}

	public int getPriceProcedure() {
		return 1000 + priceProcedure;
	}

	public String getDivideItems() {
		return "All the marriage items will be divided between the wife and the husband." ;
	}

	public int getDivorceTimeSpent() {
		return getTimeSpent() + divorceTimeSpent;
	}


	public String setResolution(boolean decition) {
		System.out.println("The resolution is that with the sign of this paper, you two are no longer a marriage.");
		if(decition) {
			return "You won the Trial, You will take care of your children";
		} else {
			return "You lost the Trial, The mother will take care of the childrens";
		}
	}

	public String getPriceConsult() {
		return "The price of the consult is " + priceConsult + "and the cost of the trial is " + priceProcedure;
	}
}
