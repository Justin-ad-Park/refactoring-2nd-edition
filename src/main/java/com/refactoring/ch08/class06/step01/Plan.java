package com.refactoring.ch08.class06.step01;

public class Plan {

	private final int base;
	private final int unit;

	public Plan(int base, int unit) {
		this.base = base;
		this.unit = unit;
	}

	public int getBase() {
		return base;
	}

	public int getUnit() {
		return unit;
	}

	private Integer getDiscountThreshold() {
		return 5000;
	}

	private double getDiscountFactor() {
		return 0.5;
	}

	public static void main(String[] args) {
		Plan pricingPlan = retrievePricingPlan();
		Order order = retreiveOrder();
		int baseCharge = pricingPlan.getBase();
		int charge;
		int chargePerUnit = pricingPlan.getUnit();
		Integer units = order.getUnits();
		int discount;
		charge = baseCharge + units * chargePerUnit;
		int discountableUnits = Math.max(units - pricingPlan.getDiscountThreshold(), 0);
		discount = (int)(discountableUnits * pricingPlan.getDiscountFactor());
		if (order.isRepeat()){
			discount += 20;
		}
		charge = charge - discount;
		changeOrder(charge);
	}

	private static void changeOrder(int charge) {
		return;
	}

	private static Plan retrievePricingPlan() {
		return new Plan(10000, 1000);
	}

	private static Order retreiveOrder() {
		return new Order(1000);
	}
}
