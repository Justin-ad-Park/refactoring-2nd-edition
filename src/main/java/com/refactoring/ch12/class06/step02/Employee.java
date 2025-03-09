package com.refactoring.ch12.class06.step02;

import java.util.List;

public class Employee {
	private final String name;
	private final EmployeeType type;

	public Employee(String name, String type) {
		this.validateType(type);
		this.name = name;
		this.type = createEmployeeType(type);
	}

	private void validateType(String type) {
		if (!List.of("engineer", "manager", "salesperson").contains(type)) {
			throw new IllegalArgumentException("invalid type=" + type);
		}
	}

	public static EmployeeType createEmployeeType(String value) {
		return switch (value) {
			case "engineer" -> new Engineer();
			case "manager" -> new Manager();
			case "salesperson" -> new Salesperson();
			default -> throw new IllegalArgumentException("invalid type=" + value);
		};
	}

	@Override
	public String toString() {
		return String.format("%s %s", this.name, this.type.getCapitalizedName());
	}
}
