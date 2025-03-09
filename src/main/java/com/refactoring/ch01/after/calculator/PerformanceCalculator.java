package com.refactoring.ch01.after.calculator;

public interface PerformanceCalculator {
    int amount();

    int volumeCredits();

    default int volumeCredits(int audience) {
        return Math.max(audience - 30, 0);
    }

}
