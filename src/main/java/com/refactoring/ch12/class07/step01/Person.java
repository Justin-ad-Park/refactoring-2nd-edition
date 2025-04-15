package com.refactoring.ch12.class07.step01;

public class Person {
	private final String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String genderCode() {
		return "X";
	}

	public boolean isMale() {
		return this instanceof Male;
	}

	public boolean isFemale() {
		return this instanceof Female;
	}
}
