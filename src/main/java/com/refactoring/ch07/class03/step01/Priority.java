package com.refactoring.ch07.class03.step01;

import java.util.List;
import java.util.Objects;

public class Priority {
	private final String value;

	public Priority(String value) {
		if (!legalValues().contains(value)){
			throw new IllegalArgumentException("Invalid Priority Value");
		}
		this.value = value;
	}

	public static List<String> legalValues(){
		return List.of("low", "normal", "high", "rush");
	}

	public int index(){
		return legalValues().indexOf(value);
	}

	public boolean higherThan(Priority other) {
		return this.index() > other.index();
	}

	public boolean lowerThan(Priority other) {
		return this.index() < other.index();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Priority priority = (Priority)o;
		return Objects.equals(value, priority.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return value;
	}
}
