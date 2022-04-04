package com.solvd.lawFirm.humans;

abstract class Human{

	private int age;
	private String name;
	private boolean efficent;

	public Human(String name, int edad, boolean efficient) {
		this.name = name;
		this.age = edad;
		this.efficent = efficient;
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
		return this.efficent;
	}

	public void setName(String name) {this.name += name;}

}
