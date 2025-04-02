package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder09Test {
    @org.junit.jupiter.api.Test
    void ReadOrder09Test() throws IOException {
        long result = ReadOrder09.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }
}