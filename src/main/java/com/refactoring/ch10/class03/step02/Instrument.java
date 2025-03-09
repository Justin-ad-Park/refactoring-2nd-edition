package com.refactoring.ch10.class03.step02;

public class Instrument {
	private final int capital;
	private final int interestRate;
	private final int duration;
	private final int income;
	private final double adjustmentFactor;

	public Instrument(int capital, int interestRate, int duration, int income, double adjustmentFactor) {
		this.capital = capital;
		this.interestRate = interestRate;
		this.duration = duration;
		this.income = income;
		this.adjustmentFactor = adjustmentFactor;
	}

	public int getCapital() {
		return capital;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public int getDuration() {
		return duration;
	}

	public int getIncome() {
		return income;
	}

	public double getAdjustmentFactor() {
		return adjustmentFactor;
	}
}
