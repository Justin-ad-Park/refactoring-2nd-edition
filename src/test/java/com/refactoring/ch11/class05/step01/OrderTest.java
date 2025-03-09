package com.refactoring.ch11.class05.step01;

import com.refactoring.ch11.class05.step01.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

	@DisplayName("할인이 적용된 최종 가격을 계산한다")
	@Test
	void getFinalPrice() {
		// given
		Order order = new Order(10, 1000);
		// when
		int price = order.getFinalPrice();
		// then
		Assertions.assertThat(price).isEqualTo(9500);
	}

}
