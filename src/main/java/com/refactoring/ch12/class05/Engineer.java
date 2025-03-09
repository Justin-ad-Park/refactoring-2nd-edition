package com.refactoring.ch12.class05;

public class Engineer extends Employee {
	private final int quota;

	public Engineer(int quota) {
		super();
		this.quota = quota;
	}

	@Override
	public int sayQuota() {
		return quota * 2;
	}
}
