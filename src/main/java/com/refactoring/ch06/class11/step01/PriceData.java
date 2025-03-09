package com.refactoring.ch06.class11.step01;


public class PriceData {
	private final int basePrice;
	private final int quantity;
	private final int discount;

	public PriceData(int basePrice, int quantity, int discount) {
		this.basePrice = basePrice;
		this.quantity = quantity;
		this.discount = discount;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getDiscount() {
		return discount;
	}
}
