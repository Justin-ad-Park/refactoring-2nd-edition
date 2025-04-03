package com.refactoring.ch06._11splitphase;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder28Test {
    @org.junit.jupiter.api.Test
    void test() {
        ReadOrder28 readOrder28 = new ReadOrder28();
        long result = 0;
        try {
            result = readOrder28.run(new String[]{"-r","orders.json"});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(2, result);
    }
}