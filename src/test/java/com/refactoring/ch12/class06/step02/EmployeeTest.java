package com.refactoring.ch12.class06.step02;

import com.refactoring.ch12.class06.step02.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	@DisplayName("직원의 이름과 단축타입 정보를 출력한다")
	@Test
	void testToString() {
		// given
		Employee employee = new Employee("kim", "engineer");
		// when
		String string = employee.toString();
		// then
		Assertions.assertThat(string).hasToString("kim En");
	}
}
