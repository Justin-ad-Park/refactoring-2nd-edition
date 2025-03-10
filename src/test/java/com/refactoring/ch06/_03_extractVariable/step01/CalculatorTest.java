package com.refactoring.ch06._03_extractVariable.step01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	@DisplayName("calculate order price")
	@Test
	void price(){
	    // given
		Calculator calculator = new Calculator();
		Order order = new Order(10, 1000);
		// when
		int price = calculator.price(order);
		// then
		Assertions.assertThat(price).isEqualTo(10100);
	}
}
