package com.refactoring.ch12.class10.step02;

public class Extra {
	private final String name;
	private final int fee;

	public Extra(String name, int fee) {
		this.name = name;
		this.fee = fee;
	}

	public String getName() {
		return name;
	}

	public int getFee() {
		return fee;
	}

	public boolean hasOwnProperty(String property) {
		return name.equals(property);
	}

}
