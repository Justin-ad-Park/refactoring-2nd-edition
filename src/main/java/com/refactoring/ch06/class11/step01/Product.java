package com.refactoring.ch06.class11.step01;

public class Product {
	private final int basePrice; // 기본 가격
	private final double discountRate; // 할인율
	private final int discountThreshold; // 할인 임계값

	public Product(int basePrice, double discountRate, int discountThreshold) {
		this.basePrice = basePrice;
		this.discountRate = discountRate;
		this.discountThreshold = discountThreshold;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public int getDiscountThreshold() {
		return discountThreshold;
	}
}
