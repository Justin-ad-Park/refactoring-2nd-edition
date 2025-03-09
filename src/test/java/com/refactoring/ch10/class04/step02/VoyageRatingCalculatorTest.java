package com.refactoring.ch10.class04.step02;

import com.refactoring.ch10.class04.step02.RatingCalculator;
import com.refactoring.ch10.class04.step02.Voyage;
import com.refactoring.ch10.class04.step02.VoyageHistory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class VoyageRatingCalculatorTest {

	@DisplayName("선박 정보와 선박의 항해 이력을 참고하여 선박의 항해 투자 등급을 계산한다")
	@Test
	void rating(){
	    // given
		Voyage voyage = new Voyage("중국", 10);
		List<VoyageHistory> history = List.of(
			new VoyageHistory("동인도", 5),
			new VoyageHistory("서인도", 15),
			new VoyageHistory("중국", -2),
			new VoyageHistory("서아프리카", 7)
		);
		// when
		String rating = new RatingCalculator().rating(voyage, history);
		// then
		String expected = "A";
		Assertions.assertThat(rating).isEqualTo(expected);
	}

}
