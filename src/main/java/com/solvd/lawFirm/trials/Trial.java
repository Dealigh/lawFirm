package com.solvd.lawFirm.trials;

public class Trial<T extends Procedure> {

    private T trial;

    public Trial(T trial) {
        this.trial = trial;
    }

    @Override
    public String toString() {
        return "We declare this trial, of " + trial.getPart1() + " versus " + trial.getPart2() + "INITIATED.";
    }
}
