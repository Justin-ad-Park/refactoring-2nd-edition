package com.refactoring.ch10.class05.step02;

import com.refactoring.ch10.class05.before.Customer;

public class Site {
	private final Customer customer;

	public Site(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return this.customer.getName().equals("미확인 고객") ? new UnknownCustomer() : this.customer;
	}
}
