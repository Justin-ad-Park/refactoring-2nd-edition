package com.refactoring.ch12.class04;

public class Salesperson extends Employee {
	public Salesperson(int quota) {
		super(quota);
	}

	@Override
	public int sayQuota() {
		return quota * 3;
	}
}
