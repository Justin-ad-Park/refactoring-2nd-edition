package com.refactoring.ch12.class08.step00;

import java.util.List;

public class Department {
	private String name;
	private final List<Employee> employee;

	public Department(String name, List<Employee> employee) {
		this.name = name;
		this.employee = employee;
	}

	public int getMonthlyCost() {
		return employee.stream()
			.mapToInt(Employee::getMonthlyCost)
			.sum();
	}
	
	public int getHeadCount() {
		return employee.size();
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public int getAnnualCost() {
		return getMonthlyCost() * 12;
	}
}
