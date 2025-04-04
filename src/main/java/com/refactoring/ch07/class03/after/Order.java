package com.refactoring.ch07.class03.after;

public class Order {
	private final Long id;
	private final Priority priority;

	public Order(Long id, String priorityString) {
		this.id = id;
		this.priority = new Priority(priorityString);
	}

	public Long getId() {
		return id;
	}

	public Priority getPriority() {
		return priority;
	}

	public String getPriorityString() {
		return priority.toString();
	}
}
