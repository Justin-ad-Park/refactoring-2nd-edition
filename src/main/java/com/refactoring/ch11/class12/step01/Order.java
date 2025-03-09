package com.refactoring.ch11.class12.step01;

public class Order {
	private final int quantity;
	private final int price;
	private final String country;

	public Order(int quantity, int price, String country) {
		this.quantity = quantity;
		this.price = price;
		this.country = country;
	}

	public String getCountry() {
		return country;
	}
}
