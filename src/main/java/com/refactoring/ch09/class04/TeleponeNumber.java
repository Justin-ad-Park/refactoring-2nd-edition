package com.refactoring.ch09.class04;

import java.util.Objects;

public class TeleponeNumber {
	private final String areaCode;
	private final String number;

	public TeleponeNumber(String areaCode, String number) {
		this.areaCode = areaCode;
		this.number = number;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TeleponeNumber that = (TeleponeNumber)o;
		return Objects.equals(areaCode, that.areaCode) && Objects.equals(number, that.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(areaCode, number);
	}
}
