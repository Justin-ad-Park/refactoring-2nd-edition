package com.refactoring.ch12.class08.step00;

public class Employee {
	String name;
	private final int id;
	private final int monthlyCost;

	public Employee(String name, int id, int monthlyCost) {
		this.name = name;
		this.id = id;
		this.monthlyCost = monthlyCost;
	}

	public int getMonthlyCost() {
		return monthlyCost;
	}

	public int getAnualCost() {
		return monthlyCost * 12;
	}
	
	public int getId() {
		return id;
	}
}
