package com.refactoring.ch11.class02.step02;

import com.refactoring.ch11.class02.step02.ChargeCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChargeCalculatorTest {

	@DisplayName("기본 요금을 계산한다")
	@Test
	void baseCharge(){
	    // given
		ChargeCalculator calculator = new ChargeCalculator();
		// when
		int baseCharge = calculator.baseCharge(200);
		// then
		Assertions.assertThat(baseCharge).isEqualTo(8000);
	}

}
