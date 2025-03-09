package com.refactoring.ch11.class05.step01;

public class Order {

	private final int quantity;
	private final int itemPrice;

	public Order(int quantity, int itemPrice) {
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public int getFinalPrice() {
		int basePrice = this.quantity * this.itemPrice;
		return this.discountedPrice(basePrice);
	}

	private int discountedPrice(int basePrice) {
		return switch (getDiscountLevel()) {
			case 1 -> (int)(basePrice * 0.95);
			case 2 -> (int)(basePrice * 0.9);
			default -> basePrice;
		};
	}

	private int getDiscountLevel() {
		return this.quantity > 100 ? 2 : 1;
	}
}
