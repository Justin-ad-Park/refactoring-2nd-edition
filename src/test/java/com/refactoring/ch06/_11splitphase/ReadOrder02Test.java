package com.refactoring.ch06._11splitphase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ReadOrder02Test {
    @Test
    void ReadOrder02Test() throws IOException {
        long result = ReadOrder02.run(new String[] {"-r", "orders.json"});
        Assertions.assertEquals(2L, result);
    }

}