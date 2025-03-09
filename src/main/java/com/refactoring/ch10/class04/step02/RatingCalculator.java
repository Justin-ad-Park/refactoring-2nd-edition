package com.refactoring.ch10.class04.step02;

import java.util.List;

public class RatingCalculator {
	public String rating(Voyage voyage, List<VoyageHistory> history) {
		return RatingFactory.createRating(voyage, history).value();
	}
}
