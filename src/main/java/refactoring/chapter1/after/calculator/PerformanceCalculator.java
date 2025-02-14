package refactoring.chapter1.after.calculator;

import refactoring.chapter1.data.Play;

public interface PerformanceCalculator {
    int amount();

    int volumeCredits();

    default int volumeCredits(int audience) {
        return Math.max(audience - 30, 0);
    }


    static PerformanceCalculator createPerformanceCalculator(int audience, Play play) {
        return switch (play.type()) {
            case "tragedy" -> new TragedyPerformanceCalculator(audience, play);
            case "comedy" -> new ComedyPerformanceCalculator(audience, play);
            default -> throw new IllegalArgumentException("알 수 없는 장르: " + play.type());
        };

    }
}
