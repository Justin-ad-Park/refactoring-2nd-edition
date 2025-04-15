package com.refactoring.ch11.class06;

public class HeatingPlan_step03 {

	private final int min;
	private final int max;
	private final Thermostat thermostat;

	public HeatingPlan_step03(int min, int max) {
		this.min = min;
		this.max = max;
		this.thermostat = new Thermostat(25);
	}

	public int targetTemperature(int selectedTemperature) {
		if (selectedTemperature > max) {
			return max;
		} else if (selectedTemperature < min) {
			return min;
		}
		return selectedTemperature;
	}
}
