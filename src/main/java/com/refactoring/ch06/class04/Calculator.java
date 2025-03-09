package com.refactoring.ch06.class04;

public class Calculator {

	// before
	// public boolean isBasePrice(Order order) {
	// 	int basePrice = order.basePrice();
	// 	return basePrice > 1000;
	// }

	// after
	public boolean isBasePrice(Order order) {
		return order.basePrice() > 1000;
	}
}
