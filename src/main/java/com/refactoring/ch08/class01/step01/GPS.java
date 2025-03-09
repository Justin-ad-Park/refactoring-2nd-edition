package com.refactoring.ch08.class01.step01;

import java.util.List;

public class GPS {

	private final Calculator calculator;

	public GPS(List<Point> points) {
		this.calculator = new Calculator(points);
	}

	public Track trackSummary(){
		double pace = (double)calculateTime() / 60 / calculator.calculateDistance();
		return new Track(calculateTime(), calculator.calculateDistance(), pace);
	}

	private int calculateTime() {
		return 3600;
	}
}
