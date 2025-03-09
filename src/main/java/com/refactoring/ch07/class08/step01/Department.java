package com.refactoring.ch07.class08.step01;

public class Department {
	private String chargeCode;
	private String manager;

	public Department(String chargeCode, String manager) {
		this.chargeCode = chargeCode;
		this.manager = manager;
	}

	public String getChargeCode() {
		return chargeCode;
	}

	public String getManager() {
		return manager;
	}
}
