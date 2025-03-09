package com.refactoring.ch12.class10.step02;

import com.refactoring.ch12.class10.step02.Bird;
import com.refactoring.ch12.class10.step02.BirdInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BirdTest {

	@DisplayName("아프리카 제비의 비행 속도는 40 - 2 * 제비의 마릿수이다")
	@Test
	void getAirSpeedVelocity() {
		// given
		BirdInfo birdInfo = new BirdInfo("빨간 아프리카 제비", "붉음", "아프리카 제비", 5, 20, true);
		Bird bird = Bird.createBird(birdInfo);
		// when
		int result = bird.getAirSpeedVelocity();
		// then
		Assertions.assertThat(result).isEqualTo(30);
	}

	@DisplayName("유럽 제비의 비행 속도는 35이다")
	@Test
	void getAirSpeedVelocityForEuropeanSwallow() {
		// given
		BirdInfo birdInfo = new BirdInfo("빨간 유럽 제비", "붉음", "유럽 제비", 5, 20, true);
		Bird bird = Bird.createBird(birdInfo);
		// when
		int result = bird.getAirSpeedVelocity();
		// then
		Assertions.assertThat(result).isEqualTo(35);
	}

	@DisplayName("네일이 없는 전압이 50의 노르웨이 파란 앵무의 비행속도는 15이다")
	@Test
	void getAirSpeedVelocityForNorwegianBlueParrot() {
		BirdInfo birdInfo = new BirdInfo("노르웨이 파란 앵무", "파람", "노르웨이 파란 앵무", 5, 50, false);
		Bird bird = Bird.createBird(birdInfo);
		// when
		int result = bird.getAirSpeedVelocity();
		// then
		Assertions.assertThat(result).isEqualTo(15);
	}

	@DisplayName("전압이 100이 넘는 노르웨이 파란 앵무의 깃털은 그을렸다")
	@Test
	void getPlumageForNorwegianBlueParrot_whenMoreThan100Voltage_thenBeCharred() {
		BirdInfo birdInfo = new BirdInfo("노르웨이 파란 앵무", "파람", "노르웨이 파란 앵무", 5, 150, false);
		Bird bird = Bird.createBird(birdInfo);
		// when
		String result = bird.getPlumage();
		// then
		Assertions.assertThat(result).isEqualTo("그을렸다");
	}
}
