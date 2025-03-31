package com.refactoring.ch06._05_chageFunction.step04;

import java.util.List;

public class NewEngland {

	private List<String> states = List.of("MA", "CT", "ME", "VT", "NH", "RI");

	// public boolean isNewEngland(Customer customer) {
	// 	return isNewEngland(customer.getAddress().getState());
	// }

	public boolean isNewEngland(String state) {
		return states.contains(state);
	}
}
