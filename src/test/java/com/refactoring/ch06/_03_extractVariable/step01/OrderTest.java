package com.refactoring.ch06._03_extractVariable.step01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
	@DisplayName("calculate order price")
	@Test
	void price(){
	    // given
		Order order = new Order(10, 1000);
		// when
		int price = order.price();
		// then
		Assertions.assertThat(price).isEqualTo(10100);
	}
}
