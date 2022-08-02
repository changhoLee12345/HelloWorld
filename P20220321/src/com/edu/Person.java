package com.edu;

public class Person extends Object {
	// field.
	// : 이름, 나이, 키, 몸무게
	private String name;
	private int age;
	private double height;
	private double weight;

	// constructor.
	// overloading.(중복선언)
	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age, double height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	// method.
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
