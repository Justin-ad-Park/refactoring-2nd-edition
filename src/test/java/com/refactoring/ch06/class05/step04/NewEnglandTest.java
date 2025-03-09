package com.refactoring.ch06.class05.step04;

import com.refactoring.ch06.class05.step04.Address;
import com.refactoring.ch06.class05.step04.Customer;
import com.refactoring.ch06.class05.step04.NewEngland;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NewEnglandTest {

	@DisplayName("customer is contained in NewEngland")
	@Test
	void isNewEngland(){
	    // given
		Customer customer1 = new Customer("John Doe", new Address("RI"));
		Customer customer2 = new Customer("Bob", new Address("AA"));
		Customer customer3 = new Customer("Smith", new Address("CT"));
		List<Customer> customers = List.of(customer1, customer2, customer3);
		NewEngland newEngland = new NewEngland();
		// when
		List<Customer> newEndangers = customers.stream()
			.filter(c->newEngland.isNewEngland(c.getAddress().getState()))
			.toList();
		// then
		Assertions.assertThat(newEndangers)
			.hasSize(2)
			.extracting(Customer::getName)
			.containsExactlyInAnyOrder("John Doe", "Smith");
	}
}
