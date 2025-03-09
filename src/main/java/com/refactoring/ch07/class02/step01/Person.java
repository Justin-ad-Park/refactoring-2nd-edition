package com.refactoring.ch07.class02.step01;

import java.util.List;

public class Person {
	private String name;
	private List<Course> courses;

	public Person(String name, List<Course> courses) {
		this.name = name;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
