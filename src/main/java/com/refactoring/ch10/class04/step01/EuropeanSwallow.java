package com.refactoring.ch10.class04.step01;

public class EuropeanSwallow extends Bird{
	public EuropeanSwallow(Bird bird) {
		super(bird.getName(), bird.getType(), bird.getNumberOfCoconuts(), bird.getVoltage(), bird.isNailed());
	}

	@Override
	public String plumage() {
		return "보통이다";
	}

	@Override
	public Integer airSpeedVelocity() {
		return 35;
	}
}
