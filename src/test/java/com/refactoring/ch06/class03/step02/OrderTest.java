package com.refactoring.ch06.class03.step02;

import com.refactoring.ch06.class03.step02.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

	@DisplayName("calculate order price")
	@Test
	void price(){
	    // given
		Order order = new Order(100, 10000);
		// when
		int price = order.price();
		// then
		Assertions.assertThat(price).isEqualTo(1_000_100);
	}

}
