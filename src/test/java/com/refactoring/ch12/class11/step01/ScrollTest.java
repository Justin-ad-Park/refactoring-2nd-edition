package com.refactoring.ch12.class11.step01;

import com.refactoring.ch12.class11.step01.Scroll;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class ScrollTest {

	@DisplayName("해당 스크롤은 클리닝이 필요하다")
	@Test
	void needsCleaning() {
		// given
		Scroll scroll = new Scroll(1, "stone", List.of("revered"), LocalDate.of(1900, 1, 1));
		// when
		boolean result = scroll.needsCleaning(LocalDate.now());
		// then
		Assertions.assertThat(result).isTrue();
	}
}
