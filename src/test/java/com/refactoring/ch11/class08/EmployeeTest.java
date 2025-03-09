package com.refactoring.ch11.class08;

import com.refactoring.ch11.class08.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	@DisplayName("직원 객체를 생성한다")
	@Test
	void instance() {
		// given
		String name = "kim";
		Employee.TypeCode typeCode = Employee.TypeCode.ENGINEER;
		// when
		Employee kim = Employee.createEmployee(name, typeCode);
		Employee kim2 = Employee.createEngineer(name);
		// then
		Assertions.assertThat(kim).isNotNull();
		Assertions.assertThat(kim2).isNotNull();
	}
}
