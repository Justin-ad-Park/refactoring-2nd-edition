package com.refactoring.ch11.class12.step01;

import java.util.Map;

public class CountryData {
	private final Map<String, String> shippingRules;

	public CountryData(Map<String, String> shippingRules) {
		this.shippingRules = shippingRules;
	}

	public Map<String, String> getShippingRules() {
		return shippingRules;
	}
}
