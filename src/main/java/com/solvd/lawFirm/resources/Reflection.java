package com.solvd.lawFirm.resources;

import com.solvd.lawFirm.trials.Jurisprudence;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;

public class Reflection {
    private static final Logger LOGG = LogManager.getLogger(Reflection.class);

    public String getRecursionResult() {

        Constructor[] constructors = Jurisprudence.class.getDeclaredConstructors();

        Jurisprudence previousTrials = null;
        try {
            previousTrials = (Jurisprudence) constructors[0].newInstance();
            Field[] fields = previousTrials.getClass().getDeclaredFields();

            Method firstMethod = previousTrials.getClass().getDeclaredMethod("get" + StringUtils.capitalize(fields[0].getName()));
            Method secondMethod = previousTrials.getClass().getDeclaredMethod("get" + StringUtils.capitalize(fields[1].getName()));
            Method thirdMethod = previousTrials.getClass().getDeclaredMethod("get" + StringUtils.capitalize(fields[2].getName()));

            Object procedure = firstMethod.invoke(previousTrials);
            Object judgeName = secondMethod.invoke(previousTrials);
            Object year = thirdMethod.invoke(previousTrials);
            IReflectionResult reflectionResult = () -> "get" + StringUtils.capitalize(fields[0].getName()) + "\n" +
                    "get" + StringUtils.capitalize(fields[1].getName()) + "\n" +
                    "get" + StringUtils.capitalize(fields[2].getName()) + "\n";

            return reflectionResult.display() + procedure.toString() + " - " + judgeName.toString() + " - " + year;

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "";
    }
}
