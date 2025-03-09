package com.refactoring.ch12.class01;

import com.refactoring.ch12.class01.Department;
import com.refactoring.ch12.class01.Employee;
import com.refactoring.ch12.class01.Party;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	@DisplayName("직원의 연간 비용을 계산한다")
	@Test
	void getAnnualCostForEmployee() {
		// given
		Party employee = new Employee(100);
		// when
		int annualCost = employee.getAnnualCost();
		// then
		Assertions.assertThat(annualCost).isEqualTo(1200);
	}

	@DisplayName("부서의 연간 비용을 계산한다")
	@Test
	void getAnnualCostForDepartment() {
		// given
		Party department = new Department(200);
		// when
		int annualCost = department.getAnnualCost();
		// then
		Assertions.assertThat(annualCost).isEqualTo(2400);
	}

}
