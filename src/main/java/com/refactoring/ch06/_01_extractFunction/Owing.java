package com.refactoring.ch06._01_extractFunction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Owing {

	public String statement(Invoice invoice){
		StringBuilder builder = new StringBuilder();
		builder.append(banner());
		final int outstanding = calculateOutstanding(invoice);
		builder.append(detailed(invoice, outstanding));
		return builder.toString();
	}

	private String banner() {
		return """
			************************
			**** customer owing ****
			************************

			""";
	}

	private int calculateOutstanding(Invoice invoice) {
		return invoice.getOrders()
				.stream()
				.mapToInt(Order::getAmount)
				.sum();
	}

	private String detailed(Invoice invoice, int outstanding) {
		return "customer: " + invoice.getCustomer() + "\n"
			+ "amount: " + usd(outstanding) + "\n"
			+ "due date: " + isoLocal(invoice.getDueDate()) + "\n";
	}

	private String usd(double value) {
		return String.format("$%,.2f", value);
	}

	private String isoLocal(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
}
