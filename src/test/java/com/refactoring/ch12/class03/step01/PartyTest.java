package com.refactoring.ch12.class03.step01;

import com.refactoring.ch12.class03.step01.Department;
import com.refactoring.ch12.class03.step01.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PartyTest {

	@DisplayName("직원의 연간 비용을 계산한다")
	@Test
	void getAnnualCost() {
		// given
		Employee employee = new Employee("kim", 1, 100);
		// when
		int cost = employee.getAnnualCost();
		// then
		Assertions.assertThat(cost).isEqualTo(1200);
	}

	@DisplayName("부서의 연간 비용을 계산한다")
	@Test
	void getAnuualCost() {
		// given
		Employee employee = new Employee("kim", 1, 100);
		Department department = new Department("hr", employee);
		// when
		int cost = department.getAnnualCost();
		// then
		Assertions.assertThat(cost).isEqualTo(1200);
	}

}
