package com.refactoring.ch08.class01.step01;

import java.util.List;

public class Calculator {

	private final List<Point> points;

	public Calculator(List<Point> points) {
		this.points = points;
	}

	public double calculateDistance() {
		double result = 0;
		for (int i = 1; i < points.size(); i++) {
			result += distance(points.get(i - 1), points.get(i));
		}
		return result;
	}

	private double distance(Point p1, Point p2) {
		final int EARTH_RADIUS = 3959; // 단위: 마일(mile)
		double dLat = radians(p2.getLatitude() - p1.getLatitude());
		double dLon = radians(p2.getLongitude() - p1.getLongitude());
		double a = Math.pow(Math.sin(dLat / 2), 2)
			+ Math.cos(radians(p2.getLatitude()))
			+ Math.cos(radians(p1.getLatitude()))
			* Math.pow(Math.sin(dLon / 2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return EARTH_RADIUS * c;
	}

	private double radians(int degrees) {
		return degrees * Math.PI / 180;
	}
}
