package com.refactoring.ch10.class05.step01;

public class Site {
	private final Customer customer;

	public Site(Customer customer) {
		this.customer = customer;
	}

	public Object getCustomer() {
		return customer.getName().equals("미확인 고객") ? new UnknownCustomer() : this.customer;
	}
}
