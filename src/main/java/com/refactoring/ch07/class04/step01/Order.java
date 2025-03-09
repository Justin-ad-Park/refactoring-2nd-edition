package com.refactoring.ch07.class04.step01;

public class Order {
	private final Item item;
	private final int quantity;

	public Order(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public int price(){
		return (int)(basePrice() * discountFactor());
	}

	private double discountFactor() {
		double discountFactor = 0.98;
		if (basePrice() > 1000){
			discountFactor -= 0.03;
		}
		return discountFactor;
	}

	private int basePrice() {
		return this.quantity * this.item.getPrice();
	}
}
