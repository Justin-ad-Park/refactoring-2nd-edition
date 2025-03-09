package com.refactoring.ch07.class02.step01;

public class Course {
	private String name;
	private boolean isAdvanced;

	public Course(String name, boolean isAdvanced) {
		this.name = name;
		this.isAdvanced = isAdvanced;
	}

	public String getName() {
		return name;
	}

	public boolean isAdvanced() {
		return isAdvanced;
	}

	public void setName(String name) {
		this.name = name;
	}
}
