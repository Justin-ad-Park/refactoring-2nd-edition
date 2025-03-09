package com.refactoring.ch10.class05.step01;

public class Customer {
	private final String name;
	private Plan plan;
	private PaymentHistory paymentHistory;

	public Customer(String name, Plan plan, PaymentHistory paymentHistory) {
		this.name = name;
		this.plan = plan;
		this.paymentHistory = paymentHistory;
	}

	public boolean isUnknown() {
		return false;
	}

	public String getName() {
		return name;
	}

	public Plan billingPlan() {
		return this.plan;
	}

	public void setBillingPlan(Plan plan) {
		this.plan = plan;
	}

	public PaymentHistory getPaymentHistory() {
		return paymentHistory;
	}
}
