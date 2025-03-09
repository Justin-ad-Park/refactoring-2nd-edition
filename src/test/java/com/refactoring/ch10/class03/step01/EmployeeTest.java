package com.refactoring.ch10.class03.step01;

import com.refactoring.ch10.class03.step01.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	@DisplayName("pay 값을 계산한다")
	@Test
	void getPayAmount(){
	    // given
		Employee employee = new Employee(false, false, false);
		// when
		int result = employee.getPayAmount();
		// then
		Assertions.assertThat(result).isEqualTo(100);
	}
}
