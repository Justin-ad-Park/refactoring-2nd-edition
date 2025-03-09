package com.refactoring.ch10.class06.step01;

import com.refactoring.ch10.class06.step01.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CustomerTest {

	@DisplayName("손님은 1만원의 상품을 10% 할인받아서 9천원을 받는다")
	@Test
	void applyDiscount(){
	    // given
		Customer customer = new Customer(0.1);
		int price = 10000;
		// when
		int discountedPrice = customer.applyDiscount(price);
		// then
		Assertions.assertThat(discountedPrice).isEqualTo(9000);
	}

	@DisplayName("할인율이 음수인 경우 할인받을 수 없다")
	@Test
	void applyDiscount_whenDiscountRateIsNegative(){
		// given
		double discountRate = -0.1;
		// when
		Throwable throwable = Assertions.catchThrowable(() -> new Customer(discountRate));
		// then
		Assertions.assertThat(throwable)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("discountRate must positive");
	}
}
