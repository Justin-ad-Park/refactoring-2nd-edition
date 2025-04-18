package com.refactoring.ch12.class10.step20;

public class BirdInfo {
	private final String name;
	private final String plumage;
	private final String type;
	private final int numberOfCounts;
	private final int voltage;
	private final boolean isNailed;

	public BirdInfo(String name, String plumage, String type, int numberOfCounts, int voltage, boolean isNailed) {
		this.name = name;
		this.plumage = plumage;
		this.type = type;
		this.numberOfCounts = numberOfCounts;
		this.voltage = voltage;
		this.isNailed = isNailed;
	}

	public String getName() {
		return name;
	}

	public String getPlumage() {
		return plumage;
	}

	public String getType() {
		return type;
	}

	public int getNumberOfCounts() {
		return numberOfCounts;
	}

	public int getVoltage() {
		return voltage;
	}

	public boolean isNailed() {
		return isNailed;
	}
}
