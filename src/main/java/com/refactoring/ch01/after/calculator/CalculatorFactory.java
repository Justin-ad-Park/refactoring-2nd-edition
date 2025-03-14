package com.refactoring.ch01.after.calculator;

import com.refactoring.ch01.data.Play;

public class CalculatorFactory {
    public static PerformanceCalculator createPerformanceCalculator(int audience, Play play) {
        return switch (play.type()) {
            case "tragedy" -> new TragedyPerformanceCalculator(audience, play);
            case "comedy" -> new ComedyPerformanceCalculator(audience, play);
            default -> throw new IllegalArgumentException("알 수 없는 장르: " + play.type());
        };
    }
}
