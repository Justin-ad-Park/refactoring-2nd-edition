package com.refactoring.ch09.class02;

public class Organization {
	private final String title;
	private final String country;

	public Organization(String title, String country) {
		this.title = title;
		this.country = country;
	}

	public String getName() {
		return title;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return title + ", " + country;
	}
}
