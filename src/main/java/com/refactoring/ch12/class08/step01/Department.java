package com.refactoring.ch12.class08.step01;

import java.util.List;

public class Department extends Party {
	private final List<Employee> employee;

	public Department(String name, List<Employee> employee) {
		super(name);
		this.employee = employee;
	}

	@Override
	public int getMonthlyCost() {
		return employee.stream()
			.mapToInt(Employee::getAnnualCost)
			.sum();
	}
	
	public int getHeadCount() {
		return employee.size();
	}

	public List<Employee> getEmployee() {
		return employee;
	}
}
