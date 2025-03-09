package com.refactoring.ch11.class04.step02;


public class Room {
	private final TemperatureRange daysTempRange;

	public Room(TemperatureRange daysTempRange) {
		this.daysTempRange = daysTempRange;
	}

	public TemperatureRange getDaysTempRange() {
		return daysTempRange;
	}
}
