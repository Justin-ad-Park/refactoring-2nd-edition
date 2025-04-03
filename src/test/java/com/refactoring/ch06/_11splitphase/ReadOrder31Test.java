package com.refactoring.ch06._11splitphase;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder31Test {
    @org.junit.jupiter.api.Test
    void test() {
        ReadOrder31 readOrder31 = new ReadOrder31();
        long result = 0;
        try {
            result = readOrder31.run(new String[]{"-r","orders.json"});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(2, result);
    }
}