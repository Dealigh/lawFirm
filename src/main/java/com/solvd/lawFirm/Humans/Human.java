package com.solvd.lawFirm.Humans;

abstract class Human{

	private int Age;
	private String name;
	private boolean efficent;

	public Human(String nombre, int edad, boolean efficient) {
		this.name = nombre;
		this.Age = edad;
		this.efficent = efficient;
	}

	public void setAge(int age){
		this.Age = age;
	}
	public int getAge(){
		return this.Age;
	}

	public abstract String getProfession();

	public String getName() {
		return name;
	}

	public boolean getEfficient() {
		return this.efficent;
	}

}
