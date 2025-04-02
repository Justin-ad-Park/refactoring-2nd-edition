package com.refactoring.ch06._11splitphase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadOrder21Test {
    @org.junit.jupiter.api.Test
    void ReadOrder21Test() throws IOException {
        ReadOrder21 readOrder21 = new ReadOrder21();
        long result = readOrder21.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }
}