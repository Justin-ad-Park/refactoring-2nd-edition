package com.refactoring.ch06.class04;

public class Order {
	private final int quantity;
	private final int itemPrice;

	public Order(int quantity, int itemPrice) {
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public int basePrice() {
		return quantity * itemPrice;
	}
}
