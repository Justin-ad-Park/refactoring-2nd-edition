package com.refactoring.ch06.class08;

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
			.filter(t->!range.contains(t.getTemperature()))
			.toList();
	}
}
