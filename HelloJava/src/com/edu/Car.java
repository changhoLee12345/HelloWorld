package com.edu;

public class Car {
	private String model; // Sonata DN
	private int price;

	protected String company;

	public Car() {

	}

	public Car(String model, int price) {
		this.model = model;
		this.price = price;
	}

	protected void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
