package com.refactoring.ch10.class06.step01;

import org.springframework.util.Assert;

public class Customer {

	private final double discountRate;

	public Customer(double discountRate) {
		Assert.isTrue(discountRate > 0, "discountRate must positive");
		this.discountRate = discountRate;
	}

	public int applyDiscount(int price){
		return (int)(price - (price * this.discountRate));
	}
}
