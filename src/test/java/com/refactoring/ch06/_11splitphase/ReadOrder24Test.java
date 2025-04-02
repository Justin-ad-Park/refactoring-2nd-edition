package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder24Test {
    @org.junit.jupiter.api.Test
    void ReadOrder24Test() throws IOException {
        ReadOrder24 readOrder24 = new ReadOrder24();
        long result = readOrder24.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }

}