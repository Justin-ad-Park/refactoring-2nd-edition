package com.refactoring.ch06._08_introduceParameterObject.step02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class StationTest {

	@DisplayName("범위에서 벗어난 온도를 필터링합니다")
	@Test
	void readingsOutsideRange(){
	    // given
		final int min = 40;
		final int max = 55;
		List<Temperature> readings = List.of(
				new Temperature(47, LocalDateTime.of(2016, 11, 10, 9, 10, 0)),
				new Temperature(53, LocalDateTime.of(2016, 11, 10, 9, 20, 0)),
				new Temperature(58, LocalDateTime.of(2016, 11, 10, 9, 30, 0)),
				new Temperature(53, LocalDateTime.of(2016, 11, 10, 9, 40, 0)),
				new Temperature(51, LocalDateTime.of(2016, 11, 10, 9, 50, 0))
		);
		Station station = new Station("Daejeon", readings);
		NumberRange numberRange = new NumberRange(min, max);
		// when
		List<Temperature> temperatures = station.readingsOutsideRange(numberRange);
		// then
		Assertions.assertThat(temperatures)
				.hasSize(1);
	}

}
