package com.refactoring.ch01._after.after.calculator;

import com.refactoring.ch01._after.after.PerformanceCalculator;
import com.refactoring.ch01.data.Performance;
import com.refactoring.ch01.data.Play;

public class TragedyPerformanceCalculator extends PerformanceCalculator {

    public TragedyPerformanceCalculator(final Performance aPerformance, final Play aPlay) {
        super(aPerformance, aPlay);
    }

    @Override
    public int amount() {
        var result = 40000;
        if (performance().audience() > 30) {
            result += 1000 * (performance().audience() - 30);
        }
        return result;
    }

}
