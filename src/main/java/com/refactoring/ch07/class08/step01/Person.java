package com.refactoring.ch07.class08.step01;

public class Person {
	private String name;
	private Department department;

	public Person(String name, String chargeCode, String manager) {
		this.name = name;
		this.department = new Department(chargeCode, manager);
	}

	public String getName() {
		return name;
	}

	public Department getDepartment() {
		return department;
	}
}
