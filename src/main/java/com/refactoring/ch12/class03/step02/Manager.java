package com.refactoring.ch12.class03.step02;

public class Manager extends Employee {
	private final int grade;

	public Manager(String name, int grade) {
		super(name);
		this.grade = grade;
		finishConstruction();
	}

	@Override
	public boolean isPrivileged() {
		return this.grade >= 4;
	}

	public String sayMyCar() {
		return "my car is " + getCar().getName();
	}
}
