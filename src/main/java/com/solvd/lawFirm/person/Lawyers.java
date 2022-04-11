package com.solvd.lawFirm.person;

import com.solvd.lawFirm.resources.Consult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Lawyers extends Person {
	private String countryLawyer;
	private static final Logger LOGGER = LogManager.getLogger(Consult.class);
	Scanner Sc = new Scanner(System.in);

	public Lawyers(String nom, int age, boolean eficent, String countryLawyer) {
		super(nom, age, eficent);
		this.countryLawyer = countryLawyer;
	}

	public String getProfession() {
		return "This person is a lawyer. If there is a trial he has to defend you.";
	}

	public Object getLawyer(){
		ArrayList<Lawyers> listNewLawyers = new ArrayList<>();
		listNewLawyers.add(new Lawyers("Jeanna Ghulam", 25, true, "Argentina"));
		listNewLawyers.add(new Lawyers("Ivan Blagovest", 39, false, "Belarus"));
		listNewLawyers.add(new Lawyers("Simonides Yechezkel", 61, true, "Belarus"));
		listNewLawyers.add(new Lawyers("Devi Julia", 51, true, "United States"));
		listNewLawyers.add(new Lawyers("Ana Benichiatto", 41, true, "Spain"));
		listNewLawyers.add(new Lawyers("Juan Benavides", 72, true, "The Hague"));
		listNewLawyers.trimToSize();

		for (Lawyers l: listNewLawyers) {
			LOGGER.info("Lawyers that work for us that we have to offer: " + l.getName() + "Country: " + l.getCountryLawyer());
		}

		LOGGER.info("If you want any of them, just write his name. BEWARE, the country has to be the one where the trial will start.");
		String election = Sc.nextLine();
		for (Lawyers l: listNewLawyers) {
			if(l.getName().equals(election)){
				return l;
			}
		}
		return listNewLawyers.add(new Lawyers("Juan Benavides", 72, true, "The Hague"));
	}

	public String getCountryLawyer(){
		return this.countryLawyer;
	}

}
