package com.solvd.lawFirm.trials;

public class Information<T> {
    private T information;

    public Information() {
        information = null;
    }

    public void setInformation(T newProfession) {
        information = newProfession;
    }

    public T getInformation() {
        return information;
    }
}
