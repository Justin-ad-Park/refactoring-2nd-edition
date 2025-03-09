package com.refactoring.ch11.class10.step01;

import com.refactoring.ch11.class10.step01.ChargeCalculator;
import com.refactoring.ch11.class10.step01.Customer;
import com.refactoring.ch11.class10.step01.Provider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChargeCalculatorTest {

	@DisplayName("요금을 계산한다")
	@Test
	void getCharge() {
		// given
		Customer customer = new Customer(1000);
		int usage = 100;
		Provider provider = new Provider(100);
		// when
		int charge = charge(customer, usage, provider);
		// then
		Assertions.assertThat(charge).isEqualTo(100_100);
	}

	private int charge(Customer customer, int usage, Provider provider) {
		return new ChargeCalculator().getCharge(customer, usage, provider);
	}

}
