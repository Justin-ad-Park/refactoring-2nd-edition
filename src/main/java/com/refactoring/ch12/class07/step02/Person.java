package com.refactoring.ch12.class07.step02;

public class Person {
	private final String name;
	private String genderCode;

	protected Person(String name, String genderCode) {
		this.name = name;
		this.genderCode = genderCode.isEmpty() ? "X" : genderCode;
	}

	public static Person createPerson(String name, String genderCode) {
		return switch (genderCode) {
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
		return this instanceof Male || "M".equals(genderCode);
	}

	public boolean isFemale() {
		return this instanceof Female || "F".equals(genderCode);
	}
}
