package com.solvd.lawFirm.trials;


import com.solvd.lawFirm.laws.iLawCivil;
import com.solvd.lawFirm.laws.IMoney;

public class Trade extends Procedure implements iLawCivil, IMoney {


    public Trade(String part1, String part2) {
        super(part1, part2, 20000);
    }

    public String getDetailedExplanation() {
        return "IN this trial, you can resolve a problem you had when buying or selling anything, or a problem when something hasn't been used as intended or there is problems"
                + " with legal relations that it comes with contracts";
    }

    public int getPriceProcedure() {
        return 20000;
    }

    public String setResolution(boolean decition) {
        if (decition == true) {
            return "have to pay you a Compensation. We have won the trial";
        } else {
            return "don't owe us anything, we lost.";
        }
    }

    public String getEmbargo() {
        return "We just made an Embargo over his goods, he cant sell anything and judge has at disposal $20000 to secure.";
    }

    public String getMoneyOwned() {
        return "This Person has money and goods at disposal: ";
    }

    public String getPriceConsult() {
        return "The price of the consult is " + priceConsult + "and the cost of the trial is " + priceProcedure;
    }
}
