package com.refactoring.ch10.class05.step99;

public class NullPaymentHistory extends PaymentHistory {

	public NullPaymentHistory(boolean delinquent, int delinquentWeeks) {
		super(delinquent, delinquentWeeks);
	}

	@Override
	public int getWeeksDelinquentInLastYear() {
		return 0;
	}
}
