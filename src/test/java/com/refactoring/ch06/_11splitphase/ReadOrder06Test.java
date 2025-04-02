package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder06Test {
    @org.junit.jupiter.api.Test
    void ReadOrder06Test() throws IOException {
        long result = ReadOrder06.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }
}