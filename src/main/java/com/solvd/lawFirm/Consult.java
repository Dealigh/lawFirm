package com.solvd.lawFirm;

import java.util.*;


import com.solvd.lawFirm.humans.Client;
import com.solvd.lawFirm.humans.CommonPeople;
import com.solvd.lawFirm.humans.Judge;
import com.solvd.lawFirm.humans.Prosecutor;
import com.solvd.lawFirm.trials.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consult {
    private static final Logger LOGGER = LogManager.getLogger(Consult.class);

    public static void main(String[] args) {

        boolean finalResolution = false;

        Resources res = new Resources();

        Scanner sc = new Scanner(System.in);
        Scanner Sc = new Scanner(System.in);

        System.out.println("Welcome to Goldbach lawsuit, please insert your name");

        Client client = new Client(res.setPartName());

        System.out.println("Now please introduce the name of the name of the person you have problem with");
        CommonPeople secondPart = new CommonPeople(res.setPartName());

        Set<CommonPeople> newAccused = new HashSet<>();

        System.out.println("Do you want to accuse more people? Type Yes if so");
        if (Sc.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("How many more (maximum is 10)");
            int more = sc.nextInt();
            for (int i = 0; i < more && more < 10; i++) {
                System.out.println("Input the name #" + (i + 1));
                newAccused.add(new CommonPeople(res.setPartName()));
            }
            if (more >= 10) {
                LOGGER.info("Too much People");
            }
        }

        System.out.println("Can you tell me your age?");
        client.setAge(res.readInt());

        Judge designedJudge = new Judge(res.setJudgeName(), res.setJudgeAge(), res.setBoolean(), res.setBoolean());
        res.menuOptions();

        switch (sc.nextInt()) {
            case 1:
                Divorce trial = new Divorce(client.getName(), secondPart.getName());
                System.out.println(trial.getDetailedExplanation());
                System.out.println("The number of your proceedings will be: " + res.setProceedings(designedJudge.getAge(), trial.getPriceProcedure()));

                System.out.println(designedJudge.getName());

                System.out.println(trial.getPriceConsult());
                client.setMoneyOwned(trial.getPriceProcedure());
                System.out.println(client.getMoneyOwned());

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                System.out.println(trial.setResolution(finalResolution));
                System.out.println(trial.getDivideItems());
                break;
            case 2:
                LaborLawsuit laborTrial = new LaborLawsuit(client.getName(), secondPart.getName());
                System.out.println(laborTrial.getDetailedExplanation());
                System.out.println("The number of your proceedings will be: " + designedJudge.hashCode());


                System.out.println(designedJudge.getName());

                System.out.println(laborTrial.getPriceConsult());
                client.setMoneyOwned(laborTrial.getPriceProcedure());
                System.out.println(client.getMoneyOwned());

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                System.out.println(laborTrial.setResolution(finalResolution));
                break;
            case 3:
                NeighboursProblems Neighbours = new NeighboursProblems(client.getName(), secondPart.getName());
                System.out.println("The number of your proceedings will be: " + designedJudge.hashCode());

                System.out.println(Neighbours.getDetailedExplanation());
                System.out.println(designedJudge.getName());

                System.out.println(Neighbours.getPriceConsult());
                client.setMoneyOwned(Neighbours.getPriceProcedure());
                System.out.println(client.getMoneyOwned());

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                System.out.println(Neighbours.setResolution(finalResolution));
                System.out.println(Neighbours.getArbiter());
                break;
            case 4:
                Trade Trade = new Trade(client.getName(), secondPart.getName());
                System.out.println(Trade.getDetailedExplanation());
                System.out.println("The number of your proceedings will be: " + designedJudge.hashCode());


                System.out.println(designedJudge.getName());

                System.out.println(Trade.getPriceConsult());
                client.setMoneyOwned(Trade.getPriceProcedure());
                System.out.println(client.getMoneyOwned());


                System.out.println(secondPart.getProfession() + " and " + Trade.getMoneyOwned() + " We can try and embargo of his goods, Yes?");
                if (Sc.nextLine().equals("Yes")) {
                    secondPart.setEmbargo();
                    System.out.println(Trade.getEmbargo());
                }

                System.out.print(secondPart.getName() + ", ");
                for (CommonPeople C : newAccused) {
                    System.out.print(C.getName() + ", ");
                }
                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                System.out.println(Trade.setResolution(finalResolution));
                break;
            case 5:
                Criminal Criminal = new Criminal(client.getName(), secondPart.getName());
                System.out.println(Criminal.getDetailedExplanation());
                System.out.println("The number of your proceedings will be: " + designedJudge.hashCode());
                System.out.println("Do you want to accuse more people?");

                Prosecutor prosecutor = new Prosecutor(res.setJudgeName(), res.setJudgeAge(), res.setBoolean());
                res.getJudgeProsecutor(designedJudge.getName(), prosecutor.getName());


                System.out.println("Criminal trials has no cost for the victim.");
                System.out.println(secondPart.getName() + Criminal.setBehindBars());
                System.out.println(Criminal.setProof());
                System.out.print(secondPart.getName() + ", ");

                CommonPeople arrayPeople[] = new CommonPeople[newAccused.size()];
                newAccused.toArray(arrayPeople);
                for (int i = 0; i < arrayPeople.length; i++) {
                    System.out.print(arrayPeople[i].getName() + ", ");
                }

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                System.out.println(Criminal.setResolution(finalResolution));
                break;

            default:
                LOGGER.info("Invalid Selection.");
                System.exit(0);
                break;
        }

        if (finalResolution == false) {
            System.out.println("We can try to appeal this Trial to an upper court, which can see if the final resolution was fair or not");
            System.out.println("Electing new Judges...");
            ArrayList<Judge> listNewJudges = new ArrayList<>();
            for (int i = 0; i < ((int) (Math.random() * 5) + 2); i++) {
                listNewJudges.add(new Judge(res.setJudgeName(), res.setJudgeAge(), res.setBoolean(), res.setBoolean()));
            }
            listNewJudges.trimToSize();

            Iterator<Judge> iteratorJudge = listNewJudges.iterator();
            while (iteratorJudge.hasNext()) {
                System.out.println("We got the Judge: " + iteratorJudge.next().getName());
            }
            System.out.println(res.getCourtJudge(listNewJudges.toArray()));

            System.out.println("They are taking a look into this Trial...");
        }
    }

}
