package com.refactoring.ch07.class03.step01;

import java.util.Arrays;

public class Orders {
    private final Order[] orders;

    public Orders(Order[] orders) {
        this.orders = orders;
    }

    public Order[] getOrders() {
        return orders;
    }

    public long highPriorityCount() {
        return Arrays.stream(orders)
                 .filter(o -> o.getPriority() == Priority.HIGH || o.getPriority() == Priority.RUSH)
                .count();
    }

    public long lowerPriorityCount() {
        return Arrays.stream(orders)
                .filter(o -> o.getPriority() == Priority.MEDIUM || o.getPriority() == Priority.LOW)
                .count();
    }

    public long lowestPriorityCount() {
        return Arrays.stream(orders)
                .filter(o -> o.getPriority() == Priority.LOW)
                .count();
    }

    public Order getOrder(int index) {
        return orders[index];
    }
}
