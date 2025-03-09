package com.refactoring.ch06.class11.step01;

public class Order {
	public int priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
		PriceData priceData = calculatePricingData(product, quantity);
		return applyShipping(priceData, shippingMethod);
	}

	private static PriceData calculatePricingData(Product product, int quantity) {
		int basePrice = product.getBasePrice() * quantity;
		int discount = (int)(Math.max(0, quantity - product.getDiscountThreshold()) * product.getBasePrice() * product.getDiscountRate());
		return new PriceData(basePrice, quantity, discount);
	}

	private int applyShipping(PriceData priceData, ShippingMethod shippingMethod) {
		int shippingPerCase = (priceData.getBasePrice() > shippingMethod.getDiscountThreshold()) ? shippingMethod.getDiscountFee() : shippingMethod.getFeePerCase();
		int shippingCost = priceData.getQuantity() * shippingPerCase;
		return priceData.getBasePrice() - priceData.getDiscount() + shippingCost;
	}
}
