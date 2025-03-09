package com.refactoring.ch09.class05;

public class Order {
	private final int number;
	private final Customer customer;

	public Order(int number, int customerId) {
		this.number = number;
		this.customer = saveCustomer(new Customer(customerId));
	}

	private Customer saveCustomer(Customer customer) {
		return CustomerRepository.save(customer);
	}

	public int getNumber() {
		return number;
	}

	public Customer getCustomer() {
		return customer;
	}
}
