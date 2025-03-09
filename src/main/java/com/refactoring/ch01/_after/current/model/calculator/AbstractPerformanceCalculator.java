package com.refactoring.ch01._after.current.model.calculator;

import com.refactoring.ch01._after.current.model.PerformanceCalculator;
import com.refactoring.ch01._after.current.model.data.EnrichPerformance;
import com.refactoring.ch01.data.Performance;
import com.refactoring.ch01.data.Play;

public abstract class AbstractPerformanceCalculator implements PerformanceCalculator {

    @Override
    public final EnrichPerformance enrichPerformance(final Performance aPerformance, final Play aPlay) {
        return new EnrichPerformance(
                aPerformance.audience(),
                aPlay.name(),
                amountFor(aPerformance),
                volumeCreditsFor(aPerformance)
        );
    }

    protected abstract int amountFor(final Performance aPerformance);

    protected int volumeCreditsFor(final Performance aPerformance) {
        return Math.max(aPerformance.audience() - 30, 0);
    }

}
