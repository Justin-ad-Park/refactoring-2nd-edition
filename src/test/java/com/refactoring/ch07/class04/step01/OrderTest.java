package com.refactoring.ch07.class04.step01;

import com.refactoring.ch07.class04.step01.Item;
import com.refactoring.ch07.class04.step01.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

	@DisplayName("주문에 대한 가격을 계산한다")
	@Test
	void price(){
	    // given
		Order snack = new Order(new Item("snack", 1000), 10);
		// when
		int price = snack.price();
		// then
		Assertions.assertThat(price).isEqualTo(9500);

	}
}
