package com.refactoring.ch06.class01;

import java.time.LocalDate;
import java.util.List;


public class Invoice {

	private final String customer;
	private final List<Order> orders;
	private final LocalDate dueDate;

	public Invoice(String customer, List<Order> orders, LocalDateFactory factory) {
		this.customer = customer;
		this.orders = orders;
		this.dueDate = recordDueDate(factory);
	}

	private LocalDate recordDueDate(LocalDateFactory factory) {
		return factory.now().plusDays(30);
	}

	public String getCustomer() {
		return customer;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
}
