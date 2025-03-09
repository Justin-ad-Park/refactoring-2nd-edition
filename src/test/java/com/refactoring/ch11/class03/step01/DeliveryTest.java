package com.refactoring.ch11.class03.step01;

import com.refactoring.ch11.class03.step01.Delivery;
import com.refactoring.ch11.class03.step01.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DeliveryTest {

	@DisplayName("MA 주에 배달해야 하는 빠른 배송 주문의 경우에 주문 당일 기준 2일후에 배송된다")
	@Test
	void rushDeliveryDate_whenRushOrder_thenDeliveryDateIsTomorrow(){
	    // given
		Delivery delivery = new Delivery();
		Order order = new Order("MA", LocalDate.now());
		// when
		LocalDate deliveryDate = delivery.rushDeliveryDate(order);
		// then
		LocalDate expectedDeliveryDate = LocalDate.now().plusDays(2);
		Assertions.assertThat(deliveryDate).isAfterOrEqualTo(expectedDeliveryDate);
	}

	@DisplayName("ME 주에 배달해야 하는 일반 배송 주문에 대해서는 주문 당일 기준 5일후에 배송된다")
	@Test
	void regularDeliveryDate_whenBasicOrder_thenDeliveryDateIs2DaysAfter(){
		// given
		Delivery delivery = new Delivery();
		Order order = new Order("ME", LocalDate.now());
		// when
		LocalDate deliveryDate = delivery.regularDeliveryDate(order);
		// then
		LocalDate expectedDeliveryDate = LocalDate.now().plusDays(5);
		Assertions.assertThat(deliveryDate).isAfterOrEqualTo(expectedDeliveryDate);
	}
}
