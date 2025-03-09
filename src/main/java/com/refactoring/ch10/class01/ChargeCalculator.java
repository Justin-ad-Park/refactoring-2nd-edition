package com.refactoring.ch10.class01;

import java.time.LocalDate;


public class ChargeCalculator {

	private final int quantity;
	private final Plan plan;

	public ChargeCalculator(int quantity, Plan plan) {
		this.quantity = quantity;
		this.plan = plan;
	}

	public int calculateCharge(LocalDate localDate) {
		return summer(localDate) ? summerCharge() : regularCharge();
	}

	private boolean summer(LocalDate localDate) {
		return !localDate.isBefore(plan.getSummerStart()) && !localDate.isAfter(plan.getSummerEnd());
	}

	private int summerCharge() {
		return quantity * plan.getSummerRate();
	}

	private int regularCharge() {
		return quantity * plan.getRegularRate() + plan.getRegularServiceCharge();
	}
}
