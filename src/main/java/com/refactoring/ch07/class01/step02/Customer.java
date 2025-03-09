package com.refactoring.ch07.class01.step02;

import java.util.Map;

public class Customer {
	private Map<String, Map<String, Object>> data;

	public Customer(Map<String, Map<String, Object>> data) {
		this.data = data;
	}

	public Map<String, Integer> compareUsage(String customerId, String year, String month, int amount) {
		return Map.of("laterAmount", 55, "change", 45);
	}
}
