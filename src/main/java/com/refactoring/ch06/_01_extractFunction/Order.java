package com.refactoring.ch06._01_extractFunction;

public class Order {
	private final int amount;

	public Order(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
}
