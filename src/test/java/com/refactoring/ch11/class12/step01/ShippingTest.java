package com.refactoring.ch11.class12.step01;

import com.refactoring.ch11.class12.step01.CountryData;
import com.refactoring.ch11.class12.step01.Order;
import com.refactoring.ch11.class12.step01.OrderProcessingError;
import com.refactoring.ch11.class12.step01.Shipping;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ShippingTest {

	@DisplayName("배송비를 계산한다")
	@Test
	void calculateShippingCosts() {
		// given
		Shipping shipping = new Shipping(new CountryData(
			Map.of("USA", "Standard Shipping: 5-7 business days, Express Shipping: 2-3 business days")));
		Order usa = new Order(10, 1000, "USA");
		List<Map<String, Object>> errorList = new ArrayList<>();
		// when
		try {
			shipping.calculateShippingCosts(usa);
		} catch (Exception e) {
			if (e instanceof OrderProcessingError) {
				errorList.add(Map.of("order", usa, "errorCode", ((OrderProcessingError)e).getCode()));
			} else {
				throw new IllegalArgumentException();
			}
		}
		// then
		Assertions.assertThat(errorList).isEmpty();
	}

	@DisplayName("배송비를 계산한다")
	@Test
	void calculateShippingCosts_whenInvalidCountry() {
		// given
		Shipping shipping = new Shipping(new CountryData(
			Map.of("USA", "Standard Shipping: 5-7 business days, Express Shipping: 2-3 business days")));
		Order usa = new Order(10, 1000, "MA");
		List<Map<String, Object>> errorList = new ArrayList<>();
		// when
		try {
			shipping.calculateShippingCosts(usa);
		} catch (Exception e) {
			if (e instanceof OrderProcessingError) {
				errorList.add(Map.of("order", usa, "errorCode", ((OrderProcessingError)e).getCode()));
			} else {
				throw new IllegalArgumentException();
			}
		}
		// then
		Assertions.assertThat(errorList).hasSize(1);
	}

}
