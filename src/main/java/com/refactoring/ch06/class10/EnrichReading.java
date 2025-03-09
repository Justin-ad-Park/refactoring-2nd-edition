package com.refactoring.ch06.class10;

public class EnrichReading {
	private String customer;
	private double baseCharge;
	private double taxableCharge;

	public EnrichReading(String customer, double baseCharge, double taxableCharge) {
		this.customer = customer;
		this.baseCharge = baseCharge;
		this.taxableCharge = taxableCharge;
	}

	public double getBaseCharge() {
		return baseCharge;
	}

	public double getTaxableCharge() {
		return taxableCharge;
	}
}
