package com.refactoring.ch06.class05.step01;

import com.refactoring.ch06.class05.step01.Circle;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CircleTest {

	@DisplayName("calculate circumference by radius")
	@Test
	void circumference(){
	    // given
		Circle circle = new Circle();
		// when
		double result = circle.circumference(3.0);
		// then
		Assertions.assertThat(result).isCloseTo(18.8, Offset.offset(0.1));
	}
}
