package com.refactoring.ch10.class07.step01;

import com.refactoring.ch10.class07.step01.VillainDetector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class VillainDetectorTest {

	@DisplayName("조커는 빌런이기 때문에 탐색된다")
	@Test
	void checkForMiscreants(){
	    // given
		VillainDetector detector = new VillainDetector();
		List<String> people = List.of("jocker", "penguin", "pooh", "tiger");
		// when
		boolean found = detector.checkForMiscreants(people);
		// then
		Assertions.assertThat(found).isTrue();
	}

}
