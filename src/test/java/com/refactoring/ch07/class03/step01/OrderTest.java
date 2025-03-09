package com.refactoring.ch07.class03.step01;

import com.refactoring.ch07.class03.step01.Order;
import com.refactoring.ch07.class03.step01.Priority;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderTest {

	@DisplayName("주문들에서 우선순위가 높은('high' or 'rush') 주문들의 개수를 계산한다")
	@Test
	void highPriorityCount(){
	    // given
		List<Order> orders = List.of(new Order(1L, "high"), new Order(2L, "rush"), new Order(3L, "high"), new Order(4L, "low"));
		// when
		long highPriorityCount = orders.stream()
			.filter(o -> o.getPriorityString().equals("high") || o.getPriorityString().equals("rush"))
			.count();
		// then
		Assertions.assertThat(highPriorityCount).isEqualTo(3L);
	}

	@DisplayName("주문들에서 normal 우선순위보다 높은 주문들의 개수를 계산한다")
	@Test
	void higherThan(){
		// given
		List<Order> orders = List.of(new Order(1L, "high"), new Order(2L, "rush"), new Order(3L, "high"), new Order(4L, "low"));
		// when
		long highPriorityCount = orders.stream()
			.filter(o -> o.getPriority().higherThan(new Priority("normal")))
			.count();
		// then
		Assertions.assertThat(highPriorityCount).isEqualTo(3L);
	}

}
