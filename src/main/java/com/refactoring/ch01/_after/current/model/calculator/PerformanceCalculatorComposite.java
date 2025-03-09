package com.refactoring.ch01._after.current.model.calculator;

import java.util.Map;

import com.refactoring.ch01._after.current.model.PerformanceCalculator;
import com.refactoring.ch01._after.current.model.data.EnrichPerformance;
import com.refactoring.ch01.data.Performance;
import com.refactoring.ch01.data.Play;

public class PerformanceCalculatorComposite implements PerformanceCalculator {

    private final Map<String, AbstractPerformanceCalculator> calculators;

    public PerformanceCalculatorComposite() {
        this.calculators = Map.of(
                "tragedy", new TragedyPerformanceCalculator(),
                "comedy", new ComedyPerformanceCalculator()
        );
    }

    @Override
    public EnrichPerformance enrichPerformance(final Performance aPerformance, final Play aPlay) {
        final PerformanceCalculator calculator = calculators.get(aPlay.type());

        return calculator.enrichPerformance(aPerformance, aPlay);
    }

}
