package com.refactoring.ch07.class03.origin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {
    @Test
    void testHighPriorityCount() {
        Order[] orders = {
                new Order(1L, "high"),
                new Order(2L, "low"),
                new Order(3L, "rush"),
                new Order(4L, "medium")
        };
        Orders ordersObj = new Orders(orders);

        assertEquals(2, ordersObj.highPriorityCount());
    }

    @Test
    void testLowerPriorityCount() {
        Order[] orders = {
                new Order(1L, "high"),
                new Order(2L, "low"),
                new Order(3L, "rush"),
                new Order(4L, "medium")
        };
        Orders ordersObj = new Orders(orders);

        assertEquals(2, ordersObj.lowerPriorityCount());
    }

    @Test
    void testLowestPriorityCount() {
        Order[] orders = {
                new Order(1L, "high"),
                new Order(2L, "low"),
                new Order(3L, "rush"),
                new Order(4L, "medium")
        };
        Orders ordersObj = new Orders(orders);

        assertEquals(1, ordersObj.lowestPriorityCount());
    }

}