package com.refactoring.ch12.class03.step02;

public abstract class Employee {
	private final String name;
	private Car car;

	public Employee(String name) {
		this.name = name;
	}

	public void finishConstruction() {
		if (this.isPrivileged()) {
			this.assignCar();
		}
	}

	public abstract boolean isPrivileged();

	public void assignCar() {
		this.car = new Car("k3");
	}

	public Car getCar() {
		return car;
	}
}
