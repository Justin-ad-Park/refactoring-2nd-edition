package com.refactoring.ch07.class05.step01;

public class Person {
	private String name;
	private TelephoneNumber telephoneNumber;

	public Person(String name, String officeAreaCode, String officeNumber) {
		this.name = name;
		this.telephoneNumber = new TelephoneNumber(officeAreaCode, officeNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficeAreaCode() {
		return this.telephoneNumber.getAreaCode();
	}

	public void setOfficeAreaCode(String officeAreaCode) {
		this.telephoneNumber.setAreaCode(officeAreaCode);
	}

	public String getOfficeNumber() {
		return this.telephoneNumber.getNumber();
	}

	public void setOfficeNumber(String officeNumber) {
		this.telephoneNumber.setNumber(officeNumber);
	}

	public String telephoneNumber() {
		return telephoneNumber.toString();
	}
}
