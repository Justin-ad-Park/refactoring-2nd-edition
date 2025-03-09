package com.refactoring.ch10.class04.step02;

public class Voyage {
	private String zone;
	private int length;

	public Voyage(String zone, int length) {
		this.zone = zone;
		this.length = length;
	}

	public String getZone() {
		return zone;
	}

	public int getLength() {
		return length;
	}
}
