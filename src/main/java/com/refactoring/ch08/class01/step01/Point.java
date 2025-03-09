package com.refactoring.ch08.class01.step01;

public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int distance(Point target) {
		return Math.abs(this.x - target.x) + Math.abs(this.y - target.y);
	}

	public int getLatitude() {
		return this.y;
	}

	public int getLongitude() {
		return this.x;
	}
}
