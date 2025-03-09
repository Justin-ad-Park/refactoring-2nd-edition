package com.refactoring.ch10.class03.step01;

public class Employee {
	private boolean isDead;
	private boolean isSeparated;
	private boolean isRetired;

	public Employee(boolean isDead, boolean isSeparated, boolean isRetired) {
		this.isDead = isDead;
		this.isSeparated = isSeparated;
		this.isRetired = isRetired;
	}

	public int getPayAmount() {
		if (isDead){
			return deadAmount();
		}
		if (isSeparated){
			return separatedAmount();
		}
		if (isRetired){
			return retiredAmount();
		}
		return 100;
	}

	private int deadAmount() {
		return 3000;
	}

	private int separatedAmount() {
		return 2000;
	}

	private int retiredAmount() {
		return 1000;
	}
}
