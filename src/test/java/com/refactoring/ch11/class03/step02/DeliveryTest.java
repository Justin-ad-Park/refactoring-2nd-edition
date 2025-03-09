package com.refactoring.ch11.class03.step02;


import com.refactoring.ch11.class03.step02.Delivery;
import com.refactoring.ch11.class03.step02.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DeliveryTest {

	@DisplayName("MA 주에 배송해야 하는 빠른 주문은 주문 당일 기준 2일 후에 배송된다")
	@Test
	void deliveryDate(){
	    // given
		Delivery delivery = new Delivery();
		Order order = new Order("MA", LocalDate.now());
		// when
		LocalDate deliveryDate = delivery.rushDeliveryDate(order);
		// then
		LocalDate expectedDeliveryDate = LocalDate.now().plusDays(2);
		Assertions.assertThat(deliveryDate).isEqualTo(expectedDeliveryDate);
	}

}
