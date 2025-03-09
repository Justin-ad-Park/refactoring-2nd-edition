package com.refactoring.ch12.class10.step02;

public class AfricanSwallowDelegate extends SpeciesDelegate {

	private final int numberOfCoconuts;

	public AfricanSwallowDelegate(BirdInfo data, Bird bird) {
		super(data, bird);
		this.numberOfCoconuts = data.getNumberOfCounts();
	}

	public int getAirSpeedVelocity() {
		return 40 - 2 * numberOfCoconuts;
	}
}
