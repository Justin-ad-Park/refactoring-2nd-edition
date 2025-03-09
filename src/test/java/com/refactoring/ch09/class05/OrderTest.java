package com.refactoring.ch09.class05;

import com.refactoring.ch09.class05.Customer;
import com.refactoring.ch09.class05.CustomerRepository;
import com.refactoring.ch09.class05.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

	@DisplayName("주문의 고객간에 동치성을 테스트한다")
	@Test
	void testEquality(){
	    // given
		Order order = new Order(1, 1);
		Customer findCustomer = CustomerRepository.getById(1);
		// when
		boolean result = order.getCustomer().equals(findCustomer);
		// then
		Assertions.assertThat(result).isTrue();
	}
}
