package com.refactoring.ch06._01_extractFunction.practice._00;

import org.junit.jupiter.api.Test;

import java.util.List;

class OwingTest {
    @Test
    void statement() {
        Owing owing = new Owing();
        List<Order> orders = List.of(new Order(600), new Order(400));
        Invoice invoice = new Invoice("BigCo", orders);

        String result = owing.printOwing(invoice);

        System.out.println(result);     //매번 날짜가 변경되어 테스트가 어려움
    }
}