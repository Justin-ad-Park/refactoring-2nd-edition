package com.refactoring.ch10.class05.step02;

import com.refactoring.ch10.class05.before.*;

public class UnknownCustomer extends Customer {
	public UnknownCustomer() {
		super("거주자", new Plan("basic", 100), new PaymentHistory(false, 0));
	}

}
