package com.refactoring.ch10.class04.step01;

public class NorwegianBlueParrot extends Bird{
	public NorwegianBlueParrot(Bird bird) {
		super(bird.getName(), bird.getType(), bird.getNumberOfCoconuts(), bird.getVoltage(), bird.isNailed());
	}

	@Override
	public String plumage() {
		return getVoltage() > 100 ? "그을렸다" : "예쁘다";
	}

	@Override
	public Integer airSpeedVelocity() {
		return isNailed() ? 0 : 10 + getVoltage() / 10;
	}
}
