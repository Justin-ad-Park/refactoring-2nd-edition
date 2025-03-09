package com.refactoring.ch10.class02;

import com.refactoring.ch10.class02.DisabilityCalculator;
import com.refactoring.ch10.class02.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DisabilityCalculatorTest {
	
	@DisplayName("한 직원의 장애 수당은 1000원이다")
	@Test
	void disabilityAmount(){
	    // given
		Employee employee = new Employee(3, 10, false);
		// when
		int benefits = new DisabilityCalculator().disabilityAmount(employee);
		// then
		Assertions.assertThat(benefits).isEqualTo(1000);
	}

}
