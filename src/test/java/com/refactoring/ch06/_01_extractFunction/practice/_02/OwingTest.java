package com.refactoring.ch06._01_extractFunction.practice._02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

class OwingTest {
    @Test
    void statement() {
        List<Order> orders = List.of(new Order(600), new Order(400));
        LocalDateFactory factory = Mockito.mock(LocalDateFactory.class);

        //Given
        Mockito.when(factory.now()).thenReturn(LocalDate.of(2025, 1, 1));

        Invoice invoice = new Invoice("BigCo", orders, factory);
        Owing owing = new Owing(invoice);
        String result = owing.printOwing01();

        Assertions.assertEquals("""
                ***********************
                **** Customer Owes ****
                ***********************
                name: BigCo
                amount: 1000
                due date: 2025-01-31
                """, result);
    }

}