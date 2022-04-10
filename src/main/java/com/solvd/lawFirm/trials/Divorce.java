package com.solvd.lawFirm.trials;

import com.solvd.lawFirm.laws.ILawDivorce;
import com.solvd.lawFirm.laws.IMoney;

public class Divorce extends Procedure implements ILawDivorce, IMoney {

    public Divorce(String part1, String part2) {
        super(part1, part2, priceProcedure);
    }

    public String getDetailedExplanation() {
        return "IN this trial, u will be confronting ur soon to be ex-wife, to divide the goods you two got while married.";
    }

    public String getDivideItems() {
        return "All the marriage items will be divided between the wife and the husband.";
    }

    public int getDivorceTimeSpent() {
        return getTimeSpent() + divorceTimeSpent;
    }


    public String setResolution(boolean decition) {

        if (decition) {
            return "The resolution is that with the sign of this paper, you two are no longer a marriage. + \n You won the Trial, You will take care of your children";
        } else {
            return "The resolution is that with the sign of this paper, you two are no longer a marriage. + \n You lost the Trial, The mother will take care of the childrens";
        }
    }

    public String getDetailPriceConsult() {
        return "The price of the consult is " + priceConsult + "and the cost of the trial is " + priceProcedure;
    }

    public int getPriceProcedure() {
        return priceProcedure;
    }

    public int getPriceConsult() {
        return priceConsult;
    }
}
