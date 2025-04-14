package com.refactoring.ch11.class05;

public class OrderStep02 {

	private final int quantity;
	private final int itemPrice;

	public OrderStep02(int quantity, int itemPrice) {
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public int getFinalPrice() {
		int basePrice = this.quantity * this.itemPrice;
		return this.discountedPrice(basePrice);
	}

	private int getDiscountLevel() {
		return this.quantity > 100 ? 2 : 1;
	}

	private int discountedPrice(int basePrice) {
		return switch (getDiscountLevel()) {
			case 1 -> (int)(basePrice * 0.95);
			case 2 -> (int)(basePrice * 0.9);
			default -> basePrice;
		};
	}
}
