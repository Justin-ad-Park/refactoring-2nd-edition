package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder25Test {
    @org.junit.jupiter.api.Test
    void ReadOrder25Test() throws IOException {
        ReadOrder25 readOrder25 = new ReadOrder25();
        long result = readOrder25.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }
}