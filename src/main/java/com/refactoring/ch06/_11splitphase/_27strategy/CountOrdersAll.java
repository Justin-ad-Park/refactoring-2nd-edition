package com.refactoring.ch06._11splitphase._27strategy;

import com.refactoring.ch06._11splitphase.Order;

public class CountOrdersAll implements CountOrders {
    @Override
    public long count(Order[] orders) {
        return orders.length;
    }
}
