package com.refactoring.ch12.class10.step01;

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
}
