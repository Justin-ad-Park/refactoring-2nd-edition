package com.refactoring.ch11.class12.step01;

public class Shipping {

	private final CountryData countryData;

	public Shipping(CountryData countryData) {
		this.countryData = countryData;
	}

	public void calculateShippingCosts(Order order) {
		localShippingRules(order.getCountry());
	}

	private ShippingRules localShippingRules(String country) {
		String data = countryData.getShippingRules().get(country);
		if (data != null) {
			return new ShippingRules(data);
		}
		throw new OrderProcessingError(-23);
	}
}
