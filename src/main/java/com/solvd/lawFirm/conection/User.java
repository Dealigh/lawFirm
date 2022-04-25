package com.solvd.lawFirm.conection;

import static com.solvd.lawFirm.conection.ConnectionPool.getInfoConnectionPool;

public class User extends Thread {

    public String run(int id) {
        return getInfoConnectionPool(id);
    }
}
