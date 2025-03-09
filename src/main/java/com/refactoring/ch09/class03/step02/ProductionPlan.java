package com.refactoring.ch09.class03.step02;

import java.util.List;


public class ProductionPlan {
	private int initialProduction;
	private List<Adjustment> adjustments;
	private int productionAccumulator;

	public ProductionPlan(int production, List<Adjustment> adjustments) {
		this.initialProduction = production;
		this.productionAccumulator = 0;
		this.adjustments = adjustments;
	}

	public void applyAdjustment(Adjustment adjustment){
		this.adjustments.add(adjustment);
		this.productionAccumulator += adjustment.getAmount();
	}

	public int getProduction() {
		assert this.productionAccumulator == this.calculateProductionAccumulator();
		return initialProduction + productionAccumulator;
	}

	private int calculateProductionAccumulator() {
		return adjustments.stream()
			.mapToInt(Adjustment::getAmount)
			.sum();
	}
}
