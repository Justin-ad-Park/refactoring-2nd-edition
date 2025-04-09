package com.refactoring.ch10.class03.step20;

public class Calculator {

	public double adjustedCapital(Instrument instrument) {
		if (instrument.getCapital() <= 0.0
			|| instrument.getInterestRate() <= 0
			|| instrument.getDuration() <= 0) {
			return 0;
		}
		return ((double)instrument.getIncome() / instrument.getDuration()) * instrument.getAdjustmentFactor();
	}
}
