package com.refactoring.ch07.class02.step03;

import java.util.Collections;
import java.util.List;

public class Person {
	private final String name;
	private final List<Course> courses;

	public Person(String name, List<Course> courses) {
		this.name = name;
		this.courses = courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void removeCourse(Course course) {
		if (!courses.contains(course)){
			throw new IllegalArgumentException("No such course");
		}else{
			courses.remove(course);
		}
	}

	public String getName() {
		return name;
	}

	public List<Course> getCourses() {
		return Collections.unmodifiableList(courses);
	}
}

