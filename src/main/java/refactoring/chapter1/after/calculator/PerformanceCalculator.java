package refactoring.chapter1.after.calculator;

import refactoring.chapter1.data.Play;

public interface PerformanceCalculator {
    int amount();

    int volumeCredits();

    default int volumeCredits(int audience) {
        return Math.max(audience - 30, 0);
    }

}
