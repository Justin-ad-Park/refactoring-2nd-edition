package com.refactoring.ch09.class05;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {
	private static final Map<Integer, Customer> store = new HashMap<>();

	public static Customer save(Customer customer) {
		if (!store.containsKey(customer.getId())){
			store.put(customer.getId(), customer);
		}
		return getById(customer.getId());
	}

	public static Customer getById(int id) {
		return store.get(id);
	}
}
