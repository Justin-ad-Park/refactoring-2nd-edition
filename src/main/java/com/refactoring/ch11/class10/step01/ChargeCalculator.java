package com.refactoring.ch11.class10.step01;

public class ChargeCalculator {
	public int getCharge(Customer customer, int usage, Provider provider) {
		int baseCharge = customer.getBaseRate() * usage;
		return baseCharge + provider.connectionCharge();
	}
}
