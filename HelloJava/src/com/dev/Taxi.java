package com.dev;

import com.edu.Car;

public class Taxi extends Car {

	public Taxi() {
		super("", 1000);
	}

	@Override
	public void setCompany(String company) {
		this.company = "new" + company;
	}
}
