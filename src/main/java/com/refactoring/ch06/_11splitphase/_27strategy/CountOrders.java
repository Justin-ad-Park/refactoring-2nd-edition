package com.refactoring.ch06._11splitphase._27strategy;

import com.refactoring.ch06._11splitphase.Order;

public interface CountOrders {
    long count(Order[] orders);
}
