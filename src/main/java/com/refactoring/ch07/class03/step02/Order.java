package com.refactoring.ch07.class03.step02;

public class Order {
    private final Long id;
    private final Priority priority;

    public Order(Long id, Priority priority) {
        this.id = id;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }
}
