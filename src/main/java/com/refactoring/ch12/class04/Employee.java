package com.refactoring.ch12.class04;

public abstract class Employee {

	final int quota;

	protected Employee(int quota) {
		this.quota = quota;
	}

	public abstract int sayQuota();
}
