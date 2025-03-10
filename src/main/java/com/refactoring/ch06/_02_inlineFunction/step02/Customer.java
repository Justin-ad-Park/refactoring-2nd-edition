package com.refactoring.ch06._02_inlineFunction.step02;

public class Customer {
	private final String name;
	private final String location;

	public Customer(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}
}
