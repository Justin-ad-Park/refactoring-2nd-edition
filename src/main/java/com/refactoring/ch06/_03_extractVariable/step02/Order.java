package com.refactoring.ch06._03_extractVariable.step02;

public class Order {
	private final int quantity;
	private final int itemPrice;

	public Order(int quantity, int itemPrice) {
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public int price(){
		// price = basePrice - quantity discount + delivery
		return getBasePrice() - getQuantityDiscount() + getShipping();
	}

	private int getBasePrice() {
		return quantity * itemPrice;
	}

	private int getQuantityDiscount() {
		return (int)(Math.max(0, quantity - 500) * itemPrice * 0.05);
	}

	private int getShipping(){
		return (int)Math.min(quantity * itemPrice * 0.1, 100);
	}
}
