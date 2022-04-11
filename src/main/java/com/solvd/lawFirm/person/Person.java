package com.solvd.lawFirm.person;

public abstract class Person {

	private int age;
	private String name;
	private boolean eficent;

	public Person(String name, int edad, boolean efficient) {
		this.name = name;
		this.age = edad;
		this.eficent = efficient;
	}

	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}

	public abstract String getProfession();

	public String getName() {
		return name;
	}

	public boolean getEfficient() {
		return this.eficent;
	}

	public void setName(String name) {this.name += name;}

	public String getRole(){ return "";};

	public void setEficient() {
		this.eficent = false;
	}

}
