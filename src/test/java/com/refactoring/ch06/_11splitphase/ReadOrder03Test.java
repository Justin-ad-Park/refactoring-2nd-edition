package com.refactoring.ch06._11splitphase;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class ReadOrder03Test {
    @Test
    void ReadOrder03Test() throws IOException {
        long result = ReadOrder03.run(new String[] {"-r", "orders.json"});
        assertEquals(2L, result);
    }
}