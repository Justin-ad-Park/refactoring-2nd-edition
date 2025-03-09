package com.refactoring.ch12.class02;

public abstract class Employee {
	private final String name;

	public Employee(String name) {
		this.name = name;
	}

	public String sayName() {
		return "hello my name is " + name;
	}
}
