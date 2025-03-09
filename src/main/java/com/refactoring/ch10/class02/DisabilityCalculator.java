package com.refactoring.ch10.class02;

public class DisabilityCalculator {
	public int disabilityAmount(Employee employee){
		return isNotEligibleForDisability(employee) ? 0 : 1000;
	}

	private boolean isNotEligibleForDisability(Employee employee) {
		return employee.getSeniority() < 2 || employee.getMonthsDisabled() > 12 || employee.isPartTime();
	}
}
