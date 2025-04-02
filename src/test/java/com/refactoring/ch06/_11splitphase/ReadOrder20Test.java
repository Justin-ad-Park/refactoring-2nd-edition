package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder20Test {
    @org.junit.jupiter.api.Test
    void ReadOrder20Test() throws IOException {
        ReadOrder20 readOrder20 = new ReadOrder20();
        long result = readOrder20.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }
}