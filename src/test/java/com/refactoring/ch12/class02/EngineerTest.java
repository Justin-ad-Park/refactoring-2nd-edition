package com.refactoring.ch12.class02;

import com.refactoring.ch12.class02.Employee;
import com.refactoring.ch12.class02.Engineer;
import com.refactoring.ch12.class02.Salesperson;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EngineerTest {

	@DisplayName("직원의 이름을 말한다")
	@Test
	void sayName() {
		// given
		Employee engineer = new Engineer("kim");
		// when
		String result = engineer.sayName();
		// then
		Assertions.assertThat(result).isEqualTo("hello my name is kim");
	}

	@DisplayName("세일즈맨이 자신의 이름을 말한다")
	@Test
	void sayNameForSalesperson() {
		// given
		Employee salesperson = new Salesperson("lee");
		// when
		String result = salesperson.sayName();
		// then
		Assertions.assertThat(result).isEqualTo("hello my name is lee");
	}
}
