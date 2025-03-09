package com.refactoring.ch11.class02.step01;

import com.refactoring.ch11.class02.step01.Calculator;
import com.refactoring.ch11.class02.step01.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@DisplayName("한 사람의 월급을 10% 올려서 계산한다")
	@Test
	void tenPercentRaise(){
	    // given
		Calculator calculator = new Calculator();
		Person person = new Person(2_000_000);
		// when
		int salary = calculator.tenPercentRaise(person);
		// then
		Assertions.assertThat(salary).isEqualTo(2_200_000);
	}

	@DisplayName("한 사람의 월급을 5% 올려서 계산한다")
	@Test
	void fivePercentRaise(){
		// given
		Calculator calculator = new Calculator();
		Person person = new Person(2_000_000);
		// when
		int salary = calculator.fivePercentRaise(person);
		// then
		Assertions.assertThat(salary).isEqualTo(2_100_000);
	}
}
