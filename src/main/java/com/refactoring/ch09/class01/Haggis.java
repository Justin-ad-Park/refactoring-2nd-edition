package com.refactoring.ch09.class01;

public class Haggis {

	public double distanceTravelled(Scenario scenario, int time){
		return getPrimary(scenario, minDelay(scenario.getDelay(), time)) +
			getSecondary(scenario, getSecondaryTime(time, scenario.getDelay()));
	}

	private double getSecondaryTime(double time, double delay) {
		return time - delay;
	}

	private double getPrimary(Scenario scenario, double primaryTime) {
		return 0.5 * scenario.primaryAcceleration() * primaryTime * primaryTime;
	}

	private double minDelay(double delay, int time) {
		return Math.min(time, delay);
	}

	private double getSecondary(Scenario scenario, double secondaryTime) {
		return secondaryTime > 0 ? scenario.primaryVelocity() * secondaryTime + 0.5 * scenario.secondaryAcceleration() * secondaryTime * secondaryTime : 0;
	}
}
