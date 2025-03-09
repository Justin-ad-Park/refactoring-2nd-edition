package com.refactoring.ch11.class04.step02;


public class HeatingPlan {
	private final TemperatureRange temperatureRange;

	public HeatingPlan(TemperatureRange temperatureRange) {
		this.temperatureRange = temperatureRange;
	}

	public boolean withinRange(TemperatureRange tempRange) {
		int low = tempRange.getLow();
		int high = tempRange.getHigh();
		return (low >= this.temperatureRange.getLow())
			&& (high <= this.temperatureRange.getHigh());
	}
}
