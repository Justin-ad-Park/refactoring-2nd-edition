package com.refactoring.ch11.class04.step02;

public class TemperatureRange {
	private final int low;
	private final int high;

	public TemperatureRange(int low, int high) {
		this.low = low;
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public int getHigh() {
		return high;
	}
}
