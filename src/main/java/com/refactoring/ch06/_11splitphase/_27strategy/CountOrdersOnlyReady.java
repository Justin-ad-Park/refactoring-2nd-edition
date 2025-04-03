package com.refactoring.ch06._11splitphase._27strategy;

import com.refactoring.ch06._11splitphase.Order;

import java.util.Arrays;

public class CountOrdersOnlyReady implements CountOrders {
    @Override
    public long count(Order[] orders) {
        return Arrays.stream(orders)
                .filter(Order::isReady)
                .count();
    }
}
