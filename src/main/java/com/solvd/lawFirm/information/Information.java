package com.solvd.lawFirm.information;

import com.solvd.lawFirm.person.Judge;

import java.util.ArrayList;

public class Information<T>{

        ArrayList<T> listWorld = new ArrayList<>();

        public Information(T obj) {
                listWorld.add(obj);
        }

        public void setMorePeople(T obj) {
                listWorld.add(obj);
        }

}
