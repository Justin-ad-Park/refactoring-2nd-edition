package com.refactoring.ch10.class05.step01;

public class UnknownCustomer extends Customer{

	public UnknownCustomer() {
		super("거주자", new Plan("basic", 100), null);
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
