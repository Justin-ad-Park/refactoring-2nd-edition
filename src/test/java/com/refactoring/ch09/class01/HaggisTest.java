package com.refactoring.ch09.class01;

import com.refactoring.ch09.class01.Haggis;
import com.refactoring.ch09.class01.Scenario;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HaggisTest {

	@DisplayName("해기스의 전파 거리를 계산한다")
	@Test
	void distanceTravelled(){
	    // given
		Scenario scenario = new Scenario(10, 10, 10, 10);
		int time = 10;
		// when
		double result = new Haggis().distanceTravelled(scenario, 10);
		// then
		Assertions.assertThat(result).isEqualTo(50.0);
	}

}
