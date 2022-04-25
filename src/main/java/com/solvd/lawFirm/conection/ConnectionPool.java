package com.solvd.lawFirm.conection;

import static com.solvd.lawFirm.conection.ListDisputes.listDisputes;

public class ConnectionPool{

    public static String getInfoConnectionPool(int id) {
        ListDisputes disputes = new ListDisputes(0, "", "", 0);
        disputes = (ListDisputes) listDisputes(id);
        return disputes.getTerritories() + " between ," + disputes.getCountries() + " since " + disputes.getSinceWhen();
    }
}
