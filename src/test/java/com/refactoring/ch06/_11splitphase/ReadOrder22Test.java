package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder22Test {
    @org.junit.jupiter.api.Test
    void ReadOrder22Test() throws IOException {
        ReadOrder22 readOrder22 = new ReadOrder22();
        long result = readOrder22.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }
}