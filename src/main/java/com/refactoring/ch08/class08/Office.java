package com.refactoring.ch08.class08;

public class Office {
	private String name;
	private String country;
	private String telephone;

	public Office(String name, String country, String telephone) {
		this.name = name;
		this.country = country;
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getTelephone() {
		return telephone;
	}
}
