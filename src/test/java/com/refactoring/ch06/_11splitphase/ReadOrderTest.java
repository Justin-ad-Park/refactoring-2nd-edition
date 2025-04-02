package com.refactoring.ch06._11splitphase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class ReadOrderTest {
    @Test
    void ReadOrder01Test() throws IOException {
        ReadOrder01.run(new String[] {"-r", "orders.json"});
    }

}