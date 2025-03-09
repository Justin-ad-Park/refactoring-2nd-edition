package com.refactoring.ch10.class02;

public class Employee {
	private final int seniority;
	private final int monthsDisabled;
	private final boolean isPartTime;

	public Employee(int seniority, int monthsDisabled, boolean isPartTime) {
		this.seniority = seniority;
		this.monthsDisabled = monthsDisabled;
		this.isPartTime = isPartTime;
	}

	public int getSeniority() {
		return seniority;
	}

	public int getMonthsDisabled() {
		return monthsDisabled;
	}

	public boolean isPartTime() {
		return isPartTime;
	}
}
