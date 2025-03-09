package com.refactoring.ch10.class01;

import com.refactoring.ch10.class01.ChargeCalculator;
import com.refactoring.ch10.class01.Plan;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ChargeCalculatorTest {

	@DisplayName("요금을 계산한다")
	@Test
	void calculateCharge(){
	    // given
		ChargeCalculator calculator = new ChargeCalculator(10,
			new Plan(LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 31), 10, 20));
		// when
		int result = calculator.calculateCharge(LocalDate.of(2024, 8, 2));
		// then
		Assertions.assertThat(result).isEqualTo(100);
	}
}
