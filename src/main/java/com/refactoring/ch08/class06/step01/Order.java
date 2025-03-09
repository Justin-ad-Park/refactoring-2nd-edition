package com.refactoring.ch08.class06.step01;

public class Order {
	private final int units;

	public Order(int units) {
		this.units = units;
	}

	public int getUnits() {
		return units;
	}

	public boolean isRepeat() {
		return true;
	}
}
