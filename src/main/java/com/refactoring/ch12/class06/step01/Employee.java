package com.refactoring.ch12.class06.step01;

public class Employee {
	private final String name;

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
