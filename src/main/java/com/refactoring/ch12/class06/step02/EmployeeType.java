package com.refactoring.ch12.class06.step02;

public class EmployeeType {
	public String getCapitalizedName() {
		return this.toString().toUpperCase().charAt(0) + "" + this.toString().toLowerCase().charAt(1);
	}
}
