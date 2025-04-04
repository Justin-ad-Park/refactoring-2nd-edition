package com.refactoring.ch07.class04.step01;

import static org.junit.jupiter.api.Assertions.*;

class OriginOrderTest {
    @org.junit.jupiter.api.Test
    void price() {
        // given
        OriginOrder snack = new OriginOrder(new Item("snack", 1000), 10);
        // when
        int price = snack.price();
        // then
        assertEquals(9500, price);
    }
}