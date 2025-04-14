package com.refactoring.ch11.class05;

public class OrderStep01 {

	private final int quantity;
	private final int itemPrice;

	public OrderStep01(int quantity, int itemPrice) {
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public int getFinalPrice() {
		int basePrice = this.quantity * this.itemPrice;
		return this.discountedPrice(basePrice, getDiscountLevel());
	}

	private int getDiscountLevel() {
		return this.quantity > 100 ? 2 : 1;
	}

	private int discountedPrice(int basePrice, int discountLevel) {
		return switch (discountLevel) {
			case 1 -> (int)(basePrice * 0.95);
			case 2 -> (int)(basePrice * 0.9);
			default -> basePrice;
		};
	}

}
