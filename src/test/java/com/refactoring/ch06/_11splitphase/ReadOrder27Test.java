package com.refactoring.ch06._11splitphase;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder27Test {
    @org.junit.jupiter.api.Test
    void test() {
        ReadOrder27 readOrder27 = new ReadOrder27();
        long result = 0;
        try {
            result = readOrder27.run(new String[]{"-r","orders.json"});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(2, result);
    }

}