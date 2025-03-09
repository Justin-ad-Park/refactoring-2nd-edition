package com.refactoring.ch09.class06;

public class Energy {

	private static final double STANDARD_GRAVITY = 9.81;

	public double potentialEnergy(double mass, double height) {
		return mass * STANDARD_GRAVITY * height;
	}
}
