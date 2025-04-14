package com.refactoring.ch10.class05.step99;

public class UnknownCustomer extends Customer {

	public UnknownCustomer() {
		super(true, "거주자", new Plan("basic", 100), new PaymentHistory(false, 0));
	}

	@Override
	public boolean isUnknown() {
		return true;
	}

	@Override
	public void setBillingPlan(Plan plan){
		// this code is ignored
	}

	@Override
	public PaymentHistory getPaymentHistory() {
		return new NullPaymentHistory(false, 0);
	}
}
