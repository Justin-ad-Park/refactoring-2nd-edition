package com.refactoring.ch06.class09;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Reading {
	private final String customer;
	private final int quantity;
	private final LocalDate time;

	public Reading(String customer, int quantity, LocalDate time) {
		this.customer = customer;
		this.quantity = quantity;
		this.time = time;
	}

	public double calculateTaxableCharge(){
		return Math.max(0, calculateBaseCharge() - taxThreshold());
	}

	private double calculateBaseCharge() {
		return baseRate() * quantity;
	}

	private double baseRate() {
		Map<Integer, double[]> baseMap = new HashMap<>();
		baseMap.put(2023,  new double[]{0.1, 0.1, 0.12, 0.12, 0.15, 0.15, 0.18, 0.18, 0.2, 0.2, 0.22, 0.22});
		baseMap.put(2024,  new double[]{0.1, 0.1, 0.12, 0.12, 0.15, 0.15, 0.18, 0.18, 0.2, 0.2, 0.22, 0.22});

		return baseMap.get(time.getYear())[time.getMonthValue() - 1];
	}

	public double taxThreshold() {
		Map<Integer, Double> taxMap = new HashMap<>();
		taxMap.put(2023, 0.2);
		taxMap.put(2024, 0.2);

		return taxMap.getOrDefault(time.getYear(), 0.0);
	}
}
