package com.refactoring.ch06.class05.step01;

public class Circle {

	// before
	// public double circum(double radius) {
	// 	return 2 * Math.PI * radius;
	// }

	// after
	public double circumference(double radius) {
		return 2 * Math.PI * radius;
	}
}
