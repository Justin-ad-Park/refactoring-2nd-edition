package com.refactoring.ch06.class03.step01;

public class Order {
	private final int quantity;
	private final int itemPrice;

	public Order(int quantity, int itemPrice) {
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getItemPrice() {
		return itemPrice;
	}
}
