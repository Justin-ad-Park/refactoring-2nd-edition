package com.refactoring.ch11.class05;

public class OrderBefore {

	private final int quantity;
	private final int itemPrice;

	public OrderBefore(int quantity, int itemPrice) {
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public int getFinalPrice() {
		int basePrice = this.quantity * this.itemPrice;

		int discountLevel;

		if(this.quantity > 100) {
			discountLevel = 2;
		} else {
			discountLevel = 1;
		}

		return this.discountedPrice(basePrice, discountLevel);
	}

	private int discountedPrice(int basePrice, int discountLevel) {
		return switch (discountLevel) {
			case 1 -> (int)(basePrice * 0.95);
			case 2 -> (int)(basePrice * 0.9);
			default -> basePrice;
		};
	}

}
