package com.refactoring.ch11.class08;

public class Employee {
	enum TypeCode {
		ENGINEER, SALESMAN, MANAGER;
	}

	private final String name;
	private final TypeCode typeCode;

	public Employee(String name, TypeCode typeCode) {
		this.name = name;
		this.typeCode = typeCode;
	}

	public static Employee createEmployee(String name, TypeCode typeCode) {
		return new Employee(name, typeCode);
	}

	public static Employee createEngineer(String name) {
		return new Employee(name, TypeCode.ENGINEER);
	}
}
