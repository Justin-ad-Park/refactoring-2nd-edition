package com.refactoring.ch11.class12.step01;

public class ShippingRules {
	private final String data;

	public ShippingRules(String data) {
		this.data = data;
	}

	public int calculateShippingCosts(Order order) {
		return 1000;
	}
}
