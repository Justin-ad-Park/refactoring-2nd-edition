package com.refactoring.ch06._08_introduceParameterObject.step02;

public class NumberRange {
	private final int min;
	private final int max;

	public NumberRange(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public boolean contains(int value) {
		return value >= min && value <= max;
	}
}
