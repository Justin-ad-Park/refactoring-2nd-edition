package com.refactoring.ch07.class03.step02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {
    @Test
    void testHighPriorityCount() {
        Order[] orders = {
                new Order(1L, Priority.HIGH),
                new Order(2L, Priority.LOW),
                new Order(3L, Priority.RUSH),
                new Order(4L, Priority.MEDIUM)
        };
        Orders ordersObj = new Orders(orders);

        assertEquals(2, ordersObj.highPriorityCount(Priority.MEDIUM));
    }

    @Test
    void testLowerPriorityCount() {
        Order[] orders = {
                new Order(1L, Priority.HIGH),
                new Order(2L, Priority.LOW),
                new Order(3L, Priority.RUSH),
                new Order(4L, Priority.MEDIUM)
        };
        Orders ordersObj = new Orders(orders);

        assertEquals(2, ordersObj.lowerPriorityCount(Priority.HIGH));
    }

    @Test
    void testLowestPriorityCount() {
        Order[] orders = {
                new Order(1L, Priority.HIGH),
                new Order(2L, Priority.LOW),
                new Order(3L, Priority.RUSH),
                new Order(4L, Priority.MEDIUM)
        };
        Orders ordersObj = new Orders(orders);

        assertEquals(1, ordersObj.lowestPriorityCount());
    }

    @Test
    void testequalPriorityCount() {
        Order[] orders = {
                new Order(1L, Priority.HIGH),
                new Order(2L, Priority.LOW),
                new Order(3L, Priority.RUSH),
                new Order(4L, Priority.MEDIUM)
        };
        Orders ordersObj = new Orders(orders);

        assertEquals(1, ordersObj.equalPriorityCount(Priority.RUSH));

    }

}