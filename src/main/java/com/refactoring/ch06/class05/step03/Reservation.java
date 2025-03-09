package com.refactoring.ch06.class05.step03;

import java.util.*;


public class Reservation {

	private Queue<Customer> firstServedReservations = new LinkedList<>();
	private Queue<Customer> priorityReservations = new PriorityQueue<>();

	// public void addReservation(Customer customer){
	// 	newAddReservation(customer, false);
	// }

	public void addReservation(Customer customer, boolean isPriority) {
		if (isPriority){
			this.priorityReservations.add(customer);
		}else{
			this.firstServedReservations.add(customer);
		}
	}

	public List<Customer> getReservations() {
		List<Customer> result = new ArrayList<>();
		Queue<Customer> temp = new LinkedList<>(firstServedReservations);
		while (!temp.isEmpty()){
			result.add(temp.poll());
		}
		return result;
	}
}
