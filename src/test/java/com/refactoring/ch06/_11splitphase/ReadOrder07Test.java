package com.refactoring.ch06._11splitphase;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder07Test {
    @Test
    void ReadOrder07Test() throws IOException {
        long result = ReadOrder07.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }
}