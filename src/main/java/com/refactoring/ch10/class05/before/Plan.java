package com.refactoring.ch10.class05.before;

import java.util.Objects;

public class Plan {
	private final String name;
	private final int amount;

	public Plan(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Plan{" +
			"name='" + name + '\'' +
			", amount=" + amount +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Plan plan = (Plan)o;
		return amount == plan.amount && Objects.equals(name, plan.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, amount);
	}
}
