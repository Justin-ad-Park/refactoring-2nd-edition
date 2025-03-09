package com.refactoring.ch12.class04;

public class Engineer extends Employee {
	public Engineer(int quota) {
		super(quota);
	}

	@Override
	public int sayQuota() {
		return quota * 2;
	}
}
