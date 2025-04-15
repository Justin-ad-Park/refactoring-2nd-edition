package com.refactoring.ch12.class07.origin;

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
}
