package com.refactoring.ch08.class02.step01;

import java.time.LocalDate;

public class Customer {
	private String name;
	private CustomerContract contract;

	public Customer(String name, double discountRate) {
		this.name = name;
		this.contract = new CustomerContract(dateToday(), discountRate);
	}

	public void becomePreferred() {
		this.setDiscountRate(contract.getDiscountRate() + 0.03);
		// other anything
	}

	public int applyDiscount(int amount) {
		return amount - (int)(amount * this.contract.getDiscountRate());
	}

	private LocalDate dateToday() {
		return LocalDate.now();
	}

	private void setDiscountRate(double discountRate) {
		this.contract.setDiscountRate(discountRate);
	}
}
