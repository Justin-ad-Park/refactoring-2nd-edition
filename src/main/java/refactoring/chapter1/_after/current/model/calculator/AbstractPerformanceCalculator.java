package refactoring.chapter1._after.current.model.calculator;

import refactoring.chapter1._after.current.model.PerformanceCalculator;
import refactoring.chapter1._after.current.model.data.EnrichPerformance;
import refactoring.chapter1.data.Performance;
import refactoring.chapter1.data.Play;

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
