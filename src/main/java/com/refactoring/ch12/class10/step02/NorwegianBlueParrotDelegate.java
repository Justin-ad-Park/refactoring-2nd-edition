package com.refactoring.ch12.class10.step02;

public class NorwegianBlueParrotDelegate extends SpeciesDelegate {
	private final int voltage;
	private final boolean isNailed;

	public NorwegianBlueParrotDelegate(BirdInfo data, Bird bird) {
		super(data, bird);
		this.voltage = data.getVoltage();
		this.isNailed = data.isNailed();
	}

	public String getPlumage() {
		if (this.voltage > 100) {
			return "그을렸다";
		}
		return this.bird.getPlumage() != null ? this.bird.getPlumage() : "예쁘다";
	}

	public int getAirSpeedVelocity() {
		return isNailed ? 0 : 10 + this.voltage / 10;
	}
}
