package com.refactoring.ch06._07_renameVariable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RenameVariableTest {

    @Test
    void before() {
        int width = 20;
        int height = 30;

        int a = width * height;
        assertEquals(600, a);
    }

    @Test
    void after_RenameVariable() {
        int width = 20;
        int height = 30;

        int area = width * height;
        assertEquals(600, area);
    }

    @Test
    void before_RenameVariable2() {
        String cpyNm = "Apple";
        assertEquals("Apple", cpyNm);
    }

    @Test
    void after_RenameVariable2() {
        String companyName = "Apple";
        assertEquals("Apple", companyName);
    }

}