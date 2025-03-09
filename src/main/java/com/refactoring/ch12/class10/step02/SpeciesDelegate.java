package com.refactoring.ch12.class10.step02;

public class SpeciesDelegate {
	final BirdInfo data;
	final Bird bird;

	public SpeciesDelegate(BirdInfo data, Bird bird) {
		this.data = data;
		this.bird = bird;
	}

	public String getPlumage() {
		return this.bird != null ? this.bird.getPlumage() : "보통이다";
	}

	public int getAirSpeedVelocity() {
		return this.bird != null ? this.bird.getAirSpeedVelocity() : 0;
	}
}
