package com.refactoring.ch12.class01;

public class Party {

	private final int monthlyCost;

	public Party(int monthlyCost) {
		this.monthlyCost = monthlyCost;
	}

	public int getAnnualCost() {
		return this.monthlyCost * 12;
	}
}
