package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder26Test {
    @org.junit.jupiter.api.Test
    void test() {
        ReadOrder26 readOrder26 = new ReadOrder26();
        long result = 0;
        try {
            result = readOrder26.run(new String[]{"-r","orders.json"});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(2, result);
    }

}