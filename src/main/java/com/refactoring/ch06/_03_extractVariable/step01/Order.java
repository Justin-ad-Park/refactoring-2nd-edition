package com.refactoring.ch06._03_extractVariable.step01;

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

	public int price(){
		// price = basePrice - quantity discount + delivery
		final int basePrice = getQuantity() * getItemPrice();
		final int quantityDiscount = (int)(Math.max(0, getQuantity() - 500) * getItemPrice() * 0.05);
		final int shipping = (int)Math.min(getQuantity() * getItemPrice() * 0.1, 100);
		return basePrice - quantityDiscount + shipping;
	}

}
