package com.refactoring.ch09.class04;

public class Person {
	private TeleponeNumber teleponeNumber;

	public Person(String areaCode, String number) {
		this.teleponeNumber = new TeleponeNumber(areaCode, number);
	}

	public String getOfficeAreaCode() {
		return teleponeNumber.getAreaCode();
	}

	public void setOfficeAreaCode(String areaCode) {
		this.teleponeNumber = new TeleponeNumber(areaCode, this.teleponeNumber.getNumber());
	}

	public String getOfficeNumber() {
		return teleponeNumber.getNumber();
	}

	public void setOfficeNumber(String number) {
		this.teleponeNumber = new TeleponeNumber(this.teleponeNumber.getAreaCode(), number);
	}
}
