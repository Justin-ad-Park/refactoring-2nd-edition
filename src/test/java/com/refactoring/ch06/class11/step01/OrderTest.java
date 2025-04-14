package com.refactoring.ch06.class11.step01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

	@DisplayName("주문의 가격을 계산한다")
	@Test
	void priceOrder(){
		Order order = new Order();
		Product car = new Product(10_000_000, 0.1, 3);
		int quantity = 5;

		int discountThreshold = 500_000;
		int discountFee = 500_000;
		int feePerCase = 100_000;
		ShippingMethod shippingMethod = new ShippingMethod(discountThreshold, discountFee, feePerCase);
		int price = order.priceOrder(car, quantity, shippingMethod);
		Assertions.assertThat(price).isEqualTo(50_500_000);
	}
}
