package com.refactoring.ch06._11splitphase._27strategy;


public class CountOrderFactory {
    public static CountOrders createCountOrders(Boolean onlyCountReady) {
        if (onlyCountReady)
            return new CountOrdersOnlyReady();
        else
            return new CountOrdersAll();
    }
}
