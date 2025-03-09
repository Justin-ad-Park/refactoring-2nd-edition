package com.refactoring.ch06.class03.step01;

import com.refactoring.ch06.class03.step01.Calculator;
import com.refactoring.ch06.class03.step01.Order;
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
