package com.refactoring.ch12.class06.step01;

public class EmployeeFactory {
	public static Employee createEmployee(String name, String type) {
		return switch (type) {
			case "engineer" -> new Engineer(name);
			case "manager" -> new Manager(name);
			default -> throw new IllegalArgumentException("Invalid employee type: " + type);
		};
	}
}
