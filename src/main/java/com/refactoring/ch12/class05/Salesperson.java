package com.refactoring.ch12.class05;

public class Salesperson extends Employee {
	private final int quota;

	public Salesperson(int quota) {
		this.quota = quota;
	}

	@Override
	public int sayQuota() {
		return quota * 3;
	}
}
