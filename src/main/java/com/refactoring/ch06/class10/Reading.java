package com.refactoring.ch06.class10;

import java.util.HashMap;
import java.util.Map;

public class Reading {
	private String customer;
	private int quantity;
	private int month;
	private int year;

	public Reading(String customer, int quantity, int month, int year) {
		this.customer = customer;
		this.quantity = quantity;
		this.month = month;
		this.year = year;
	}

	public static EnrichReading enrichReading(String customer, int quantity, int month, int year){
		double baseCharge = baseCharge(year, month, quantity);
		double taxableCharge = taxableCharge(baseCharge, taxThreshold(year));
		return new EnrichReading(customer, baseCharge, taxableCharge);
	}

	public static double baseCharge(int year, int month, int quantity) {
		return baseRate(year, month) * quantity;
	}

	private static double baseRate(int year, int month) {
		Map<Integer, double[]> baseMap = new HashMap<>();
		baseMap.put(2023,  new double[]{0.1, 0.1, 0.12, 0.12, 0.15, 0.15, 0.18, 0.18, 0.2, 0.2, 0.22, 0.22});
		baseMap.put(2024,  new double[]{0.1, 0.1, 0.12, 0.12, 0.15, 0.15, 0.18, 0.18, 0.2, 0.2, 0.22, 0.22});

		return baseMap.get(year)[month - 1];
	}

	private static double taxableCharge(double baseCharge, double taxThreshold){
		return Math.max(0, baseCharge - taxThreshold);
	}

	private static double taxThreshold(int year) {
		Map<Integer, Double> taxMap = new HashMap<>();
		taxMap.put(2023, 0.2);
		taxMap.put(2024, 0.2);

		return taxMap.getOrDefault(year, 0.0);
	}
}
