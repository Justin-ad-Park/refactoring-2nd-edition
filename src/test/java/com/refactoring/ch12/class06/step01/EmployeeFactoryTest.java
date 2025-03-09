package com.refactoring.ch12.class06.step01;

import com.refactoring.ch12.class06.step01.Employee;
import com.refactoring.ch12.class06.step01.EmployeeFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeFactoryTest {

	@DisplayName("엔지니어 직원 객체를 생성한다")
	@Test
	void createEmployee() {
		// given

		// when
		Employee engineer = EmployeeFactory.createEmployee("kim", "engineer");
		// then
		Assertions.assertThat(engineer.toString()).hasToString("kim");
	}

}
