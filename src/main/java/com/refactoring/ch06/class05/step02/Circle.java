package com.refactoring.ch06.class05.step02;

public class Circle {

	// before
	// public double circum(double radius) {
	// 	return 2 * Math.PI * radius;
	// }

	@Deprecated(since = "Circum method names are not readable", forRemoval = true)
	public double circum(double radius) {
		return circumference(radius);
	}

	public double circumference(double radius) {
		return 2 * Math.PI * radius;
	}
}
