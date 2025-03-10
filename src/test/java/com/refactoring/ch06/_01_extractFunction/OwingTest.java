package com.refactoring.ch06._01_extractFunction;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.BDDMockito.*;

class OwingTest {

	@DisplayName("Generating debt information according to Invoice")
	@Test
	void statement(){
	    // given
		String customer = "BigCo";
		List<Order> orders = List.of(new Order(600), new Order(400));
		LocalDateFactory factory = Mockito.mock(LocalDateFactory.class);
		given(factory.now()).willReturn(LocalDate.of(2024, 12, 1));

		Invoice invoice = new Invoice(customer, orders, factory);
		Owing owing = new Owing();
		// when
		String statement = owing.statement(invoice);
		// then
		String expected = """
			************************
			**** customer owing ****
			************************
			
			customer: BigCo
			amount: $1,000.00
			due date: 2024-12-31
			""";
		Assertions.assertThat(statement).isEqualTo(expected);
	}

}
