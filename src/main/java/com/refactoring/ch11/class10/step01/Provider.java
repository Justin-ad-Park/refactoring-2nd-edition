package com.refactoring.ch11.class10.step01;

public class Provider {
	private final int connectionCharge;

	public Provider(int connectionCharge) {
		this.connectionCharge = connectionCharge;
	}

	public int connectionCharge() {
		return connectionCharge;
	}
}
