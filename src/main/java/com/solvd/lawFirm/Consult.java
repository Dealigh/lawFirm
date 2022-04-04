package com.solvd.lawFirm;

import java.util.*;


import com.solvd.lawFirm.exceptions.AgeException;
import com.solvd.lawFirm.exceptions.DateException;
import com.solvd.lawFirm.exceptions.NameException;
import com.solvd.lawFirm.person.*;
import com.solvd.lawFirm.trials.*;
import org.apache.commons.lang3.StringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.lawFirm.Time.*;

public class Consult {
    private static final Logger LOGGER = LogManager.getLogger(Consult.class);

    public static void main(String[] args) throws NameException, AgeException, DateException {

        boolean finalResolution = false;
        LOGGER.info(getDate());
        Resources res = new Resources();

        Scanner sc = new Scanner(System.in);
        Scanner Sc = new Scanner(System.in);

        LOGGER.info("Welcome to Goldbach lawsuit, please insert your name");
        Client client = new Client(res.setPartName());
        LOGGER.info("Now tell me your Lastname");
        client.setName(StringUtils.SPACE + res.setPartName());

        LOGGER.info("In which country do you live in?");
        Country country = new Country("note yet", 0, false);
        country= (Country)country.getCountry(StringUtils.deleteWhitespace(Sc.nextLine().toUpperCase()));

        LOGGER.info("Now please introduce the name of the name of the person you have problem with");
        CommonPeople secondPart = new CommonPeople(res.setPartName());

        LOGGER.info("And where does he or she lives");
        country = (Country)country.setCourtCountry(StringUtils.deleteWhitespace(Sc.nextLine().toUpperCase()), StringUtils.deleteWhitespace(country.getName().toUpperCase()));
        System.out.println(country.getName());

        Set<CommonPeople> newAccused = new HashSet<>();
        LOGGER.info("Do you want to accuse more people? Type Yes if so");
        if (Sc.nextLine().equalsIgnoreCase("yes")) {
            LOGGER.info("How many more (maximum is 10)");
            int more = sc.nextInt();
            for (int i = 0; i < more && more < 10; i++) {
                LOGGER.info("Input the name #" + (i + 1));
                newAccused.add(new CommonPeople(res.setPartName()));
            }
            if (more >= 10) {
                LOGGER.info("Too much People");
            }
        }

        LOGGER.info("Can you tell me your age?");
        client.setAge(res.readInt());

        int evolvingDate = 10;
        LOGGER.info(getMoreDays(evolvingDate));
        Judge designedJudge = new Judge(res.setJudgeName(), res.setJudgeAge(), res.setBoolean(), res.setBoolean());
        res.menuOptions();

        switch (sc.nextInt()) {
            case 1:
                Divorce trial = new Divorce(client.getName(), secondPart.getName());
                evolvingDate = 20;
                LOGGER.info(getMoreDays(evolvingDate));
                LOGGER.info(trial.getDetailedExplanation());
                LOGGER.info(trial.timeDescription() + trial.getDivorceTimeSpent());
                LOGGER.info("The number of your proceedings will be: " + res.setProceedings(designedJudge.getAge(), trial.getPriceProcedure()));

                LOGGER.info("Since when you two are married? Please introduce a date in format dd/MM/yyyy");
                stringToDate(Sc.nextLine());

                LOGGER.info(trial.getJudge() + designedJudge.getName());

                LOGGER.info(trial.getPriceConsult());
                client.setMoneyOwned(trial.getPriceProcedure());
                LOGGER.info(client.getMoneyOwned());

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());

                evolvingDate += trial.getDivorceTimeSpent();
                LOGGER.debug(getMoreDays(evolvingDate));

                LOGGER.debug(trial.setResolution(finalResolution));
                LOGGER.info(trial.getDivideItems());
                break;
            case 2:
                LaborLawsuit laborTrial = new LaborLawsuit(client.getName(), secondPart.getName());
                LOGGER.info(laborTrial.getDetailedExplanation());
                LOGGER.info("The number of your proceedings will be: " + designedJudge.hashCode());


                LOGGER.info(laborTrial.getJudge() + designedJudge.getName());

                LOGGER.info(laborTrial.getPriceConsult());
                client.setMoneyOwned(laborTrial.getPriceProcedure());
                LOGGER.info(client.getMoneyOwned());

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                LOGGER.debug(laborTrial.setResolution(finalResolution));
                break;
            case 3:
                NeighboursProblems neighbours = new NeighboursProblems(client.getName(), secondPart.getName());
                LOGGER.info("The number of your proceedings will be: " + designedJudge.hashCode());

                LOGGER.info(neighbours.getDetailedExplanation());
                LOGGER.info(designedJudge.getName());

                LOGGER.info(neighbours.getPriceConsult());
                client.setMoneyOwned(neighbours.getPriceProcedure());
                LOGGER.info(client.getMoneyOwned());

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                LOGGER.debug(neighbours.setResolution(finalResolution));
                LOGGER.info(neighbours.getArbiter());
                break;
            case 4:
                Trade trade = new Trade(client.getName(), secondPart.getName());
                LOGGER.info(trade.getDetailedExplanation());
                LOGGER.info("The number of your proceedings will be: " + designedJudge.hashCode());

                LOGGER.info(designedJudge.getName());

                LOGGER.info(trade.getPriceConsult());
                client.setMoneyOwned(trade.getPriceProcedure());
                LOGGER.info(client.getMoneyOwned());


                LOGGER.info(secondPart.getProfession() + " and " + trade.getMoneyOwned() + " We can try and embargo of his goods, Yes?");
                if (Sc.nextLine().equals("Yes")) {
                    secondPart.setEmbargo();
                    LOGGER.info(trade.getEmbargo());
                }

                LOGGER.info(secondPart.getName() + ", ");
                for (CommonPeople C : newAccused) {
                    LOGGER.info(C.getName() + ", ");
                }
                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                LOGGER.debug(trade.setResolution(finalResolution));
                break;
            case 5:
                Criminal criminal = new Criminal(client.getName(), secondPart.getName());
                LOGGER.info(criminal.getDetailedExplanation());
                LOGGER.info("The number of your proceedings will be: " + designedJudge.hashCode());
                LOGGER.info("Do you want to accuse more people?");

                Prosecutor prosecutor = new Prosecutor(res.setJudgeName(), res.setJudgeAge(), res.setBoolean());
                res.getJudgeProsecutor(designedJudge.getName(), prosecutor.getName());


                LOGGER.info("Criminal trials has no cost for the victim.");
                LOGGER.info(secondPart.getName() + criminal.setBehindBars());
                LOGGER.info(criminal.setProof());
                LOGGER.info(secondPart.getName() + ", ");

                CommonPeople arrayPeople[] = new CommonPeople[newAccused.size()];
                newAccused.toArray(arrayPeople);
                for (int i = 0; i < arrayPeople.length; i++) {
                    System.out.print(arrayPeople[i].getName() + ", ");
                }

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                LOGGER.debug(criminal.setResolution(finalResolution));
                break;

            default:
                LOGGER.info("Invalid Selection.");
                System.exit(0);
                break;
        }


        LOGGER.info(getMoreDays(evolvingDate + 30));
        if (finalResolution == false) {
            LOGGER.info("We can try to appeal this Trial to an upper court, which can see if the final resolution was fair or not");
            LOGGER.info("Electing new Judges...");
            ArrayList<Judge> listNewJudges = new ArrayList<>();
            for (int i = 0; i < ((int) (Math.random() * 5) + 2); i++) {
                listNewJudges.add(new Judge(res.setJudgeName(), res.setJudgeAge(), res.setBoolean(), res.setBoolean()));
            }
            listNewJudges.trimToSize();

            for (Judge listNewJudge : listNewJudges) {
                LOGGER.info("We got the Judge: " + listNewJudge.getName());
            }
            LOGGER.info(res.getCourtJudge(listNewJudges.toArray()));

            LOGGER.info("They are taking a look into this Trial...");
        }
    }

}
