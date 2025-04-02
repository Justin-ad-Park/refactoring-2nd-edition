package com.refactoring.ch06._11splitphase;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder04Test {
    @Test
    void ReadOrder04Test() throws IOException {
        long result = ReadOrder04.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }

}