package com.refactoring.ch11.class04.step01;

public class HeatingPlan {
	private final TemperatureRange temperatureRange;

	public HeatingPlan(TemperatureRange temperatureRange) {
		this.temperatureRange = temperatureRange;
	}

	public boolean withinRange(NumberRange range) {
		return (range.getBottom() >= this.temperatureRange.getLow())
			&& (range.getTop() <= this.temperatureRange.getHigh());
	}
}
