package com.refactoring.ch07.class03.origin;

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
                 .filter(o -> o.getPriority().equals("high") || o.getPriority().equals("rush"))
                .count();
    }

    public Order getOrder(int index) {
        return orders[index];
    }
}
