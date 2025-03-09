package com.refactoring.ch11.class04.step01;

public class NumberRange {
	private final int bottom;
	private final int top;

	public NumberRange(int bottom, int top) {
		this.bottom = bottom;
		this.top = top;
	}

	public int getBottom() {
		return bottom;
	}

	public int getTop() {
		return top;
	}
}
