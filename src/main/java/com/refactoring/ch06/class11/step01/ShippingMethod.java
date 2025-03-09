package com.refactoring.ch06.class11.step01;

public class ShippingMethod {
	private final int discountThreshold;
	private final int discountFee;
	private final int feePerCase;

	public ShippingMethod(int discountThreshold, int discountFee, int feePerCase) {
		this.discountThreshold = discountThreshold;
		this.discountFee = discountFee;
		this.feePerCase = feePerCase;
	}

	public int getDiscountThreshold() {
		return discountThreshold;
	}

	public int getDiscountFee() {
		return discountFee;
	}

	public int getFeePerCase() {
		return feePerCase;
	}
}
