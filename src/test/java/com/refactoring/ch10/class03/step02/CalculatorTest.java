package com.refactoring.ch10.class03.step02;

import com.refactoring.ch10.class03.step02.Calculator;
import com.refactoring.ch10.class03.step02.Instrument;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@DisplayName("Instrument의 adjustedCaptial을 게산한다")
	@Test
	void adjustedCapital(){
	    // given
		Instrument instrument = new Instrument(10, 10, 10, 10, 0.1);
		// when
		double result = new Calculator().adjustedCapital(instrument);
		// then
		Assertions.assertThat(result).isEqualTo(0.1);
	}

}
