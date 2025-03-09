package com.refactoring.ch10.class04.step01;

public class AfricanSwallow extends Bird{
	public AfricanSwallow(Bird bird) {
		super(bird.getName(), bird.getType(), bird.getNumberOfCoconuts(), bird.getVoltage(),
				bird.isNailed());
	}

	@Override
	public String plumage() {
		return getNumberOfCoconuts() > 2 ? "지쳤다" : "보통이다";
	}

	@Override
	public Integer airSpeedVelocity() {
		return 40 - 2 * getNumberOfCoconuts();
	}
}
