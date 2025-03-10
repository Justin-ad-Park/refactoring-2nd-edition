package com.refactoring.ch06._05_chageFunctionDeclaration.step02;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CircleTest {

	@DisplayName("calculate circumference by radis")
	@Test
	void circumference(){
	    // given
		Circle circle = new Circle();
		// when
		// double result = circle.circum(3.0);
		double result = circle.circumference(3.0);
		// then
		Assertions.assertThat(result).isCloseTo(18.84, Offset.offset(0.1));

	}

}
