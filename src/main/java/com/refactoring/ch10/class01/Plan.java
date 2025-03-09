package com.refactoring.ch10.class01;

import java.time.LocalDate;

public class Plan {
	private final LocalDate summerStart;
	private final LocalDate summerEnd;
	private final int summerRate;
	private final int regularRate;

	public Plan(LocalDate summerStart, LocalDate summerEnd, int summerRate, int regularRate) {
		this.summerStart = summerStart;
		this.summerEnd = summerEnd;
		this.summerRate = summerRate;
		this.regularRate = regularRate;
	}

	public LocalDate getSummerStart() {
		return summerStart;
	}

	public LocalDate getSummerEnd() {
		return summerEnd;
	}

	public int getSummerRate() {
		return summerRate;
	}

	public int getRegularRate() {
		return regularRate;
	}

	public int getRegularServiceCharge() {
		return regularRate * 2;
	}
}
