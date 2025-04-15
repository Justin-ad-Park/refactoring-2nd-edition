package com.refactoring.ch12.class07.step09;

public class Person {
	private final String name;
	private final String genderCode;

	public Person(String name, String genderCode) {
		this.name = name;
		this.genderCode = genderCode;
	}

	public static Person createPerson(String name, String gender) {
		return switch (gender) {
			case "M" -> new Person(name, "M");
			case "F" -> new Person(name, "F");
			default -> new Person(name, "X");
		};
	}

	public String getName() {
		return name;
	}

	public String genderCode() {
		return genderCode;
	}

	public boolean isMale() {
		return "M".equals(genderCode);
	}
}
