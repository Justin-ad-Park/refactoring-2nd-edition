package com.refactoring.ch08.class04.step01;

public class Person {
	private String name;
	private Photo photo;

	public Person(String name, Photo photo) {
		this.name = name;
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public Photo getPhoto() {
		return photo;
	}
}
