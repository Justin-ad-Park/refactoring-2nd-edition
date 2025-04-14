package com.refactoring.ch10.class05.step03;

import com.refactoring.ch10.class05.before.Customer;
import com.refactoring.ch10.class05.step02.UnknownCustomer;

public class Site {
	public static final String UNKNOWN_CUSTOMER = "미확인 고객";
	private final Customer customer;
	private boolean isUnknown;


	public Site(Customer customer) {
		if (isKnownCustomer(customer)) {
			this.customer = new UnknownCustomer();
			isUnknown = true;

			return;
		}

		this.customer = customer;
		isUnknown = false;
	}

	private static boolean isKnownCustomer(Customer customer) {
		return customer.getName().equals(UNKNOWN_CUSTOMER);
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public boolean isUnknown() {
		return isUnknown;
	}
}
