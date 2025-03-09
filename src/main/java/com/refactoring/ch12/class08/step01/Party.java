package com.refactoring.ch12.class08.step01;

public abstract class Party {
	private final String name;

	public Party(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAnnualCost() {
		return getMonthlyCost() * 12;
	}

	public abstract int getMonthlyCost();
}
