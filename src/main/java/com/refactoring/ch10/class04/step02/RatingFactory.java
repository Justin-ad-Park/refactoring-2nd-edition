package com.refactoring.ch10.class04.step02;

import java.util.List;

public class RatingFactory {
	public static Rating createRating(Voyage voyage, List<VoyageHistory> history) {
		String china = "중국";
		boolean hasChinaHistory = history.stream()
			.map(VoyageHistory::getZone)
			.anyMatch(china::equals);
		if (voyage.getZone().equals(china) && hasChinaHistory) {
			return new ExperiencedChinaRating(voyage, history);
		} else {
			return new Rating(voyage, history);
		}
	}
}
