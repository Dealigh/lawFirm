package com.solvd.lawFirm.trials;

import com.solvd.lawFirm.laws.iLawCriminal;

public class Criminal extends Procedure implements iLawCriminal {

    public Criminal(String part1, String part2) {
        super(part1, part2, 0);
    }

    public int getPriceProcedure() {
        return 0;

    }

    public String getDetailedExplanation() {
        return "IN this trial, you as the victim just need to accuse someone, and the Prosecutor has to find proofs on your behalf";
    }

    public String setProsecutor() {
        return "This will set a prosecutor for your case, which will be: ";
    }

    public String setProof() {
        return "Finding...";
    }

    public String setResolution(boolean decition) {
        if (decition == true) {
            return "you have been found GUILTY of your crimes. The prosecutor won the trial";
        } else {
            return "are free. we didn't win this time, but they have criminal records now. We will catch them.";
        }
    }

    public String setBehindBars() {
        return " has been put in temporarily prison until find enough proofs to put him on trial or let him free";
    }
}
