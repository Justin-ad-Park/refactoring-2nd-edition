package com.refactoring.ch12.class10.step02;

public class EuropeanSwallowDelegate extends SpeciesDelegate {

	public EuropeanSwallowDelegate(Bird bird) {
		super(null, bird);
	}
	
	public int getAirSpeedVelocity() {
		return 35;
	}
}
