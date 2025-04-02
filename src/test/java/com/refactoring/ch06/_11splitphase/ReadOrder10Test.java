package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder10Test {
    @org.junit.jupiter.api.Test
    void ReadOrder10Test() throws IOException {
        long result = ReadOrder10.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }

}