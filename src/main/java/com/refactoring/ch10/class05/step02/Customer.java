package com.refactoring.ch10.class05.step02;

public class Customer {
	private boolean isUnknown;
	private final String name;
	private Plan plan;
	private PaymentHistory paymentHistory;

	public Customer(boolean isUnknown, String name, Plan plan, PaymentHistory paymentHistory) {
		this.isUnknown = isUnknown;
		this.name = name;
		this.plan = plan;
		this.paymentHistory = paymentHistory;
	}

	public static Customer knownCustomer(String name, Plan plan, PaymentHistory paymentHistory){
		return new Customer(false, name, plan, paymentHistory);
	}

	public static Customer create(String name) {
		return new Customer(false,  name, null, new NullPaymentHistory(false, 0));
	}

	public boolean isUnknown() {
		return isUnknown;
	}

	public String getName() {
		return name;
	}

	public Plan getBillingPlan() {
		return this.plan;
	}

	public void setBillingPlan(Plan plan) {
		this.plan = plan;
	}

	public PaymentHistory getPaymentHistory() {
		return paymentHistory;
	}

	public void setIsUnknown(boolean isUnknown) {
		this.isUnknown = isUnknown;
	}
}
