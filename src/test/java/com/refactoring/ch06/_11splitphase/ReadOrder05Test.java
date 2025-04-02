package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder05Test {
    @org.junit.jupiter.api.Test
    void ReadOrder05Test() throws IOException {
        long result = ReadOrder05.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }
}