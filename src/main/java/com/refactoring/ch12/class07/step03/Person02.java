package com.refactoring.ch12.class07.step03;

public class Person02 {
	private final String name;
	private final String genderCode;

	public Person02(String name, String genderCode) {
		this.name = name;
		this.genderCode = genderCode;
	}

	public static Person02 createPerson(String name, String gender) {
		return switch (gender) {
			case "M" -> new Person02(name, "M");
			case "F" -> new Person02(name, "F");
			default -> new Person02(name, "X");
		};
	}

	public String getName() {
		return name;
	}

	public String genderCode() {
		return genderCode;
	}

	public boolean isGender(String gender) {
		return gender.equals(gender);
	}
}
