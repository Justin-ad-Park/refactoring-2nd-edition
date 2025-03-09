package com.refactoring.ch07.class01.step01;

public class Organization {

	private String name;
	private String country;

	public Organization(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Organization{" +
			"name='" + name + '\'' +
			", country='" + country + '\'' +
			'}';
	}

	public static void main(String[] args) {
		Organization organization = new Organization("Acme Gooseberries", "US");

		System.out.println(organization.getName()); // read example
		String newName = "Acme Gooseberries, Inc.";
		organization.setName(newName);
		System.out.println(organization);
	}
}
