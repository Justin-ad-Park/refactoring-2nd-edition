package com.refactoring.ch11.class11.step01;

public class GPS {
	private Point[] points;

	public GPS(Point[] points) {
		this.points = points;
	}

	public int calculateAscent() {
		int result = 0;
		for (int i = 1; i < points.length; i++) {
			int verticalChange = points[i].getElevation() - points[i - 1].getElevation();
			result += Math.max(verticalChange, 0);
		}
		return result;
	}
}
