package com.refactoring.ch10.class07.step01;

import java.util.List;

public class VillainDetector {
	public boolean checkForMiscreants(List<String> people) {
		List<String> villain = List.of("jocker", "saruman");
		boolean found = people.stream()
			.anyMatch(villain::contains);
		if (found) {
			sendAlert();
		}
		return found;
	}

	private void sendAlert() {
		System.out.println("alert villain!!");
	}
}
