package com.refactoring.ch12.class08.step01;

public class Employee extends Party {
	private final int id;
	private final int monthlyCost;

	public Employee(String name, int id, int monthlyCost) {
		super(name);
		this.id = id;
		this.monthlyCost = monthlyCost;
	}

	@Override
	public int getMonthlyCost() {
		return monthlyCost;
	}
	
	public int getId() {
		return id;
	}
}
