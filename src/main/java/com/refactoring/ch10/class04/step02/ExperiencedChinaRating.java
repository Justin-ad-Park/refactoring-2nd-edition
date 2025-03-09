package com.refactoring.ch10.class04.step02;

import java.util.List;

public class ExperiencedChinaRating extends Rating{

	public ExperiencedChinaRating(Voyage voyage, List<VoyageHistory> history) {
		super(voyage, history);
	}

	@Override
	int captainHistoryRisk() {
		int result = super.captainHistoryRisk() - 2;
		return Math.max(result, 0);
	}

	@Override
	int voyageProfitFactor() {
		return super.voyageProfitFactor() + 3;
	}

	@Override
	int voyageLengthFactor() {
		int result = 0;
		if (getVoyage().getLength() > 12){
			result += 1;
		}
		if (getVoyage().getLength() > 18){
			result -= 1;
		}
		return result;
	}

	@Override
	int historyLengthFactor() {
		return getHistory().size() > 10 ? 1 : 0;
	}
}
