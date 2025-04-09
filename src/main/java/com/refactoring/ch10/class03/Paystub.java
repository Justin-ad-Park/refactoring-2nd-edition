package com.refactoring.ch10.class03;

public record Paystub(int amount, int bonus, String reasonCode) {

    public static Paystub noPay(String reasonCode) {
        return new Paystub(0, 0, reasonCode);
    }
}
