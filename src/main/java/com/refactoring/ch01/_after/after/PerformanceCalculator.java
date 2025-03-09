package com.refactoring.ch01._after.after;

import com.refactoring.ch01._after.after.calculator.ComedyPerformanceCalculator;
import com.refactoring.ch01._after.after.calculator.TragedyPerformanceCalculator;
import com.refactoring.ch01.data.Performance;
import com.refactoring.ch01.data.Play;

public abstract class PerformanceCalculator {

    private final Performance performance;
    private final Play play;

    protected PerformanceCalculator(final Performance aPerformance, final Play aPlay) {
        this.performance = aPerformance;
        this.play = aPlay;
    }

    public static PerformanceCalculator createPerformanceCalculator(final Performance aPerformance, final Play aPlay) {
        return switch (aPlay.type()) {
            case "tragedy" -> new TragedyPerformanceCalculator(aPerformance, aPlay);
            case "comedy" -> new ComedyPerformanceCalculator(aPerformance, aPlay);
            default -> throw new IllegalArgumentException("알 수 없는 장르: " + aPlay.type());
        };
    }

    public abstract int amount();

    public int volumeCredits() {
        return Math.max(this.performance.audience() - 30, 0);
    }

    public Performance performance() {
        return performance;
    }

    public Play play() {
        return play;
    }

}
