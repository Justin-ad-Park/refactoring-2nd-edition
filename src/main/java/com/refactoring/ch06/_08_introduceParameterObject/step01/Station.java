package com.refactoring.ch06._08_introduceParameterObject.step01;

import java.util.List;

public class Station {
	private String name;
	private List<Temperature> readings;

	public Station(String name, List<Temperature> readings) {
		this.name = name;
		this.readings = readings;
	}

	public List<Temperature> readingsOutsideRange(NumberRange range) {
		return readings.stream()
			.filter(t->t.getTemperature() < range.getMin() || t.getTemperature() > range.getMax())
			.toList();
	}
}
