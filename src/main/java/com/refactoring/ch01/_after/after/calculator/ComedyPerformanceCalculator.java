package com.refactoring.ch01._after.after.calculator;

import com.refactoring.ch01._after.after.PerformanceCalculator;
import com.refactoring.ch01.data.Performance;
import com.refactoring.ch01.data.Play;

public class ComedyPerformanceCalculator extends PerformanceCalculator {

    public ComedyPerformanceCalculator(final Performance aPerformance, final Play aPlay) {
        super(aPerformance, aPlay);
    }

    @Override
    public int amount() {
        var result = 30000;
        if (performance().audience() > 20) {
            result += 10000 + 500 * (performance().audience() - 20);
        }
        result += 300 * performance().audience();

        return result;
    }

    @Override
    public int volumeCredits() {
        return super.volumeCredits() + (performance().audience() / 5);
    }

}
