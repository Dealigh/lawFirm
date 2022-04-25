package com.solvd.lawFirm.conection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static com.solvd.lawFirm.conection.ConnectionPool.getInfoConnectionPool;

public class Display {
    private static final Logger LOGGER = LogManager.getLogger(Display.class);
    public static void mainThrid(String[] args) {

        Scanner Sc = new Scanner(System.in);
        User user = new User();

        LOGGER.info("This line is upside the territorial disputes show up, in main thread");;
        LOGGER.info(Sc.nextLine());

        user.start();

        LOGGER.info(user.run(1));
        LOGGER.info(user.run(3));
        LOGGER.info(user.run(5));
        LOGGER.info(user.run(2));

    }
}
