package com.refactoring.ch10.class05.before;

public class Site {
	private final Customer customer;

	public Site(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return this.customer;
	}
}
