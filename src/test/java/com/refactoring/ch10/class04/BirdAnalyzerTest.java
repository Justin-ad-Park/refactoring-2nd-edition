package com.refactoring.ch10.class04;

import com.refactoring.ch10.class04.step01.Bird;
import com.refactoring.ch10.class04.step01.BirdAnalyzer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class BirdAnalyzerTest {

	@DisplayName("새들을 보고 깃털 상태를 판단한다")
	@Test
	void plumages(){
	    // given
		List<Bird> birds = List.of(new Bird("빨간 유럽 제비", "유럽 제비", 10, 100, true),
			new Bird("빨간 아프리카 제비", "아프리카 제비", 10, 100, true),
			new Bird("빨간 노르웨이 앵무", "노르웨이 파란 앵무", 10, 100, true),
			new Bird("파란 제비", "한국 제비", 10, 100, true));
		// when
		Map<String, String> result = new BirdAnalyzer().plumages(birds);
		// then
		Assertions.assertThat(result.getOrDefault("빨간 유럽 제비", null)).isEqualTo("보통이다");
		Assertions.assertThat(result.getOrDefault("빨간 아프리카 제비", null)).isEqualTo("지쳤다");
		Assertions.assertThat(result.getOrDefault("빨간 노르웨이 앵무", null)).isEqualTo("예쁘다");
		Assertions.assertThat(result.getOrDefault("파란 제비", null)).isEqualTo("알 수 없다");
	}


	@DisplayName("새들을 보고 비행속도를 판단한다")
	@Test
	void speeds(){
		// given
		List<Bird> birds = List.of(new Bird("빨간 유럽 제비", "유럽 제비", 10, 100, true),
			new Bird("빨간 아프리카 제비", "아프리카 제비", 10, 100, true),
			new Bird("빨간 노르웨이 앵무", "노르웨이 파란 앵무", 10, 100, true),
			new Bird("파란 제비", "한국 제비", 10, 100, true));
		// when
		Map<String, Integer> result = new BirdAnalyzer().speeds(birds);
		// then
		Assertions.assertThat(result.getOrDefault("빨간 유럽 제비", null)).isEqualTo(35);
		Assertions.assertThat(result.getOrDefault("빨간 아프리카 제비", null)).isEqualTo(20);
		Assertions.assertThat(result.getOrDefault("빨간 노르웨이 앵무", null)).isEqualTo(0);
		Assertions.assertThat(result.getOrDefault("파란 제비", null)).isEqualTo(-1);
	}
}
