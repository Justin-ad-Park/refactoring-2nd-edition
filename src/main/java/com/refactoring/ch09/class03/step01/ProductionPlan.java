package com.refactoring.ch09.class03.step01;

import java.util.List;

public class ProductionPlan {
	private int production;
	private List<Adjustment> adjustments;

	public ProductionPlan(int production, List<Adjustment> adjustments) {
		this.production = production;
		this.adjustments = adjustments;
	}

	public void applyAdjustment(Adjustment adjustment) {
		this.adjustments.add(adjustment);
	}

	public int getProduction() {
		return this.adjustments.stream()
			.mapToInt(Adjustment::getAmount)
			.sum();
	}

	public List<Adjustment> getAdjustments() {
		return adjustments;
	}
}
