package com.refactoring.ch06._03_extractVariable.step01;

public class Calculator {
	public int price(Order order){
		// price = basePrice - quantity discount + delivery
		final int basePrice = order.getQuantity() * order.getItemPrice();
		final int quantityDiscount = (int)(Math.max(0, order.getQuantity() - 500) * order.getItemPrice() * 0.05);
		final int shipping = (int)Math.min(order.getQuantity() * order.getItemPrice() * 0.1, 100);
		return basePrice - quantityDiscount + shipping;
	}
}
