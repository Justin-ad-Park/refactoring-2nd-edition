package com.refactoring.ch10.class04.step02;

public class VoyageHistory {
	private String zone;
	private int profit;

	public VoyageHistory(String zone, int profit) {
		this.zone = zone;
		this.profit = profit;
	}

	public String getZone() {
		return zone;
	}

	public int getProfit() {
		return profit;
	}
}
