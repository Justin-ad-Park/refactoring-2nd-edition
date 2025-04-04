package com.refactoring.ch07.class03.step02;

import java.util.Arrays;

public class Orders {
    private final Order[] orders;

    public Orders(Order[] orders) {
        this.orders = orders;
    }

    public Order[] getOrders() {
        return orders;
    }

    public long highPriorityCount(Priority priority) {
        return Arrays.stream(orders)
                 .filter(o -> o.getPriority().isHigherThen(priority))
                .count();
    }

    public long lowerPriorityCount(Priority priority) {
        return Arrays.stream(orders)
                .filter(o -> o.getPriority().isLowerThen(priority))
                .count();
    }

    public Order getOrder(int index) {
        return orders[index];
    }
}
