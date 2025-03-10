package com.refactoring.ch06._08_introduceParameterObject.before;

import java.util.List;

public class Station {
	private String name;
	private List<Temperature> readings;

	public Station(String name, List<Temperature> readings) {
		this.name = name;
		this.readings = readings;
	}

	public List<Temperature> readingsOutsideRange(int min, int max) {
		return readings.stream()
				.filter(t -> t.getTemperature() < min || t.getTemperature() > max)
				.toList();
	}
}
