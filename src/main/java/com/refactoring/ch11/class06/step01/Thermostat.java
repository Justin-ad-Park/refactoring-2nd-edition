package com.refactoring.ch11.class06.step01;

public class Thermostat {

	private final int temperature;

	public Thermostat(int temperature) {
		this.temperature = temperature;
	}

	public int selectedTemperature() {
		return temperature;
	}
}
