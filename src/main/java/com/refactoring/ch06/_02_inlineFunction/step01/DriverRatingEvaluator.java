package com.refactoring.ch06._02_inlineFunction.step01;
public class DriverRatingEvaluator {

	public int rating(Driver driver) {
		// after
		return driver.getNumberOfLateDeliveries() > 5 ? 2 : 1;
	}

	// before
	// private boolean moreThanFiveLateDeliveries(Driver driver) {
	// 	return driver.getNumberOfLateDeliveries() > 5;
	// }
}
