package com.refactoring.ch12.class03.step01;

public class Department extends Party {
	private final Employee staff;

	public Department(String name, Employee staff) {
		super(name);
		this.staff = staff;
	}

	public int getAnnualCost() {
		return staff.getAnnualCost();
	}
}
