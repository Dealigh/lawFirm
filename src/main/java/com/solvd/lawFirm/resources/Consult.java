package com.solvd.lawFirm.resources;

import java.util.*;


import com.solvd.lawFirm.exceptions.*;
import com.solvd.lawFirm.person.*;
import com.solvd.lawFirm.trials.*;
import com.solvd.lawFirm.person.profession.Profession;
import org.apache.commons.lang3.StringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.lawFirm.resources.Resources.getCountryTrial;
import static com.solvd.lawFirm.resources.Time.*;

public class Consult {
    private static final Logger LOGGER = LogManager.getLogger(Consult.class);

    public static void main(String[] args) {

        boolean finalResolution = false;
        LOGGER.info(getDate());
        Resources res = new Resources();

        Scanner sc = new Scanner(System.in);
        Scanner Sc = new Scanner(System.in);

        Reflection reflection = new Reflection();
        LOGGER.info(reflection.getRecursionResult());

        LOGGER.info("Welcome to Goldbach lawsuit, please insert your name");
        Client client = new Client(res.setPartName());
        LOGGER.info("Now tell me your Lastname");
        client.setName(StringUtils.SPACE + res.setPartName());
        Part<Client> you = new Part<>(client);


        LOGGER.info("In which country do you live in?");
        Country country = new Country("note yet", 0, false);
        String temporalSave = country.getCountriesAvailable().replace("_", " ");
        country = (Country) country.getCountry(StringUtils.deleteWhitespace(temporalSave));

        LOGGER.info("Now please introduce the name of the name of the person you have problem with");
        CommonPeople secondPart = new CommonPeople(res.setPartName());

        if (secondPart.getName().equalsIgnoreCase("ARGENTINA") || secondPart.getName().equalsIgnoreCase("BELARUS") ||
                secondPart.getName().equalsIgnoreCase("UNITED STATES") || secondPart.getName().equalsIgnoreCase("SPAIN")) {
            secondPart.setCountryOfResidence(secondPart.getName());
            country = (Country) country.setCourtCountry(StringUtils.deleteWhitespace("THE HAGUE"), StringUtils.deleteWhitespace(country.getName().toUpperCase()));

        } else {
            LOGGER.info("And where does he or she lives");
            secondPart.setCountryOfResidence(Sc.nextLine());
            country = (Country) country.setCourtCountry(StringUtils.deleteWhitespace(secondPart.getCountryOfResidence().toUpperCase()), StringUtils.deleteWhitespace(country.getName().toUpperCase()));
            LOGGER.info("Which one its his job. Select between the following");
            Profession<CommonPeople> accusedJob = new Profession<>(secondPart);
            LOGGER.info("This is his salary: $" + accusedJob.getSalary() + ". Good, this will be useful later.");
        }

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

        Lawyers lawyer = new Lawyers("Not yet", 20, false, "None");
        lawyer = (Lawyers) lawyer.getLawyer();
        LOGGER.info(lawyer.getName());
        getCountryTrial(country.getName(), lawyer.getCountryLawyer());


        LOGGER.info("Can you tell me your age?");
        client.setAge(res.readInt());

        int evolvingDate = 10;
        LOGGER.info(getMoreDays(evolvingDate));

        Judge designedJudge = new Judge(res.setJudgeName(), res.setJudgeAge(), res.setBoolean(), res.setBoolean());

        res.menuOptions();

        switch (sc.nextInt()) {
            case 1:
                Divorce divorceTrial = new Divorce(client.getName(), secondPart.getName());
                Trial<Divorce> trial = new Trial<>(divorceTrial);
                evolvingDate = 20;
                LOGGER.info(trial.toString());
                LOGGER.info(getMoreDays(evolvingDate));
                LOGGER.info(divorceTrial.getDetailedExplanation());
                LOGGER.info(divorceTrial.timeDescription() + divorceTrial.getDivorceTimeSpent());
                LOGGER.info("The number of your proceedings will be: " + res.setProceedings(designedJudge.getAge(), divorceTrial.getPriceProcedure()));

                LOGGER.info("Since when you two are married? Please introduce a date in format dd/MM/yyyy");
                stringToDate(Sc.nextLine());

                LOGGER.info(divorceTrial.getJudge() + designedJudge.getName());

                LOGGER.info(divorceTrial.getDetailPriceConsult());
                client.setMoneyOwned(res.getSumPrices(divorceTrial.getPriceConsult(), divorceTrial.getPriceProcedure()));
                LOGGER.info(client.getMoneyOwned());

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());

                evolvingDate += divorceTrial.getDivorceTimeSpent();
                LOGGER.debug(getMoreDays(evolvingDate));

                LOGGER.debug(divorceTrial.setResolution(finalResolution));
                LOGGER.info(divorceTrial.getDivideItems());
                break;
            case 2:
                LaborLawsuit laborTrial = new LaborLawsuit(client.getName(), secondPart.getName());
                LOGGER.info(laborTrial.getDetailedExplanation());
                LOGGER.info("The number of your proceedings will be: " + designedJudge.hashCode());
                Trial<LaborLawsuit> trial1 = new Trial<>(laborTrial);
                evolvingDate = 20;
                LOGGER.info(trial1.toString());

                LOGGER.info(laborTrial.getJudge() + designedJudge.getName());

                LOGGER.info(laborTrial.getDetailPriceConsult());
                client.setMoneyOwned(res.getSumPrices(laborTrial.getPriceConsult(), laborTrial.getPriceProcedure()));
                LOGGER.info(client.getMoneyOwned());

                LOGGER.info(client.getMoneyOwned() + secondPart.getMoneyInPocket());
                LOGGER.info(laborTrial.getEmbargoLabor());

                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                LOGGER.debug(laborTrial.setResolution(finalResolution));
                break;
            case 3:
                NeighboursProblems neighbours = new NeighboursProblems(client.getName(), secondPart.getName());
                LOGGER.info("The number of your proceedings will be: " + designedJudge.hashCode());

                LOGGER.info(neighbours.getDetailedExplanation());
                LOGGER.info(designedJudge.getName());

                LOGGER.info(neighbours.getDetailPriceConsult());
                client.setMoneyOwned(res.getSumPrices(neighbours.getPriceConsult(), neighbours.getPriceProcedure()));
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

                LOGGER.info(trade.getDetailPriceConsult());
                client.setMoneyOwned(trade.getPriceProcedure());
                LOGGER.info(client.getMoneyOwned());


                LOGGER.info(secondPart.getProfession() + " and " + trade.getMoneyOwned() + " We can try and embargo of his goods, Yes?");
                if (Sc.nextLine().equals("Yes")) {
                    secondPart.setEmbargo();
                    LOGGER.info(trade.getEmbargo());
                }

                LOGGER.info(secondPart.getName() + ", ");
                newAccused
                        .stream()
                        .forEach(accused -> {
                            LOGGER.info(accused.getName() + ", ");
                        });
                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                LOGGER.debug(trade.setResolution(finalResolution));
                break;
            case 5:
                Criminal criminal = new Criminal(client.getName(), secondPart.getName());
                Part<CommonPeople> accused = new Part<>(secondPart);
                LOGGER.info(criminal.getDetailedExplanation());
                LOGGER.info("The number of your proceedings will be: " + designedJudge.hashCode());
                LOGGER.info("Do you want to accuse more people?");

                Prosecutor prosecutor = new Prosecutor(res.setJudgeName(), res.setJudgeAge(), res.setBoolean());
                res.getJudgeProsecutor(designedJudge.getName(), prosecutor.getName());


                LOGGER.info("Criminal trials has no cost for the victim.");
                LOGGER.info(secondPart.getName() + criminal.setBehindBars());
                LOGGER.info(criminal.setProof());
                LOGGER.info(secondPart.getName() + ", ");
                newAccused
                        .stream()
                        .forEach(nextAccused -> {
                            LOGGER.info(nextAccused.getName() + ", ");
                        });
                finalResolution = res.setDecition(designedJudge.getEfficient(), designedJudge.getJustice());
                accused.setEfficient(finalResolution);
                LOGGER.debug(criminal.setResolution(finalResolution));
                break;

            case 6:
                LOGGER.info("Do you want to know more about the accused. Put yes, if you don't write that or you write anything else we will tell" +
                        "you about the Judge. We could also say what we know about you");
                if (Sc.nextLine().equalsIgnoreCase("yes")) {
                    LOGGER.info("You want to get more information about" + secondPart.getName() + "Here's what we know so far:");
                    Part<CommonPeople> him = new Part<>(secondPart);
                    LOGGER.info(him.toString());
                    LOGGER.info("We know that he/she has " + secondPart.getMoneyInPocket() + "at disposal if we want to set an Embargo");
                } else {
                    LOGGER.info("You want to get more information about" + secondPart.getName() + "Here's what we know so far:");
                    Part<Judge> him = new Part<>(designedJudge);
                    LOGGER.info(him.toString());
                }
                break;
            default:
                throw new InvalidSelection();
        }


        LOGGER.info(getMoreDays(evolvingDate + 30));
        if (!finalResolution) {
            LOGGER.info("We can try to appeal this Trial to an upper court, which can see if the final resolution was fair or not");
            LOGGER.info("Electing new Judges...");
            ArrayList<Judge> listNewJudges = new ArrayList<>();
            listNewJudges.add(new Judge(res.setJudgeName(), res.setJudgeAge(), res.setBoolean(), res.setBoolean()));
            listNewJudges.add(new Judge(res.setJudgeName(), res.setJudgeAge(), res.setBoolean(), res.setBoolean()));
            listNewJudges.add(new Judge(res.setJudgeName(), res.setJudgeAge(), res.setBoolean(), res.setBoolean()));
            listNewJudges.trimToSize();

            listNewJudges.forEach((n) -> LOGGER.info("We got the Judge: " + n.getName()));

            listNewJudges.sort(Comparator.comparing(Person::getName));
            LOGGER.info(res.getCourtJudge(listNewJudges.toArray()));

            LOGGER.info("They are taking a look into this Trial...");
        }
    }

}
