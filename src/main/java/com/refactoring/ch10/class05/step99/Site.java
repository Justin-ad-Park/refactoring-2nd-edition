package com.refactoring.ch10.class05.step99;

public class Site {
	private final String name;
	private final String location;
	private Customer customer;

	public Site(String name, String location, Customer customer) {
		this.name = name;
		this.location = location;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return this.customer.getName().equals("미확인 고객") ? createUnknownCustomer() : this.customer;
	}

	private Customer createUnknownCustomer(){
		return new UnknownCustomer();
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
