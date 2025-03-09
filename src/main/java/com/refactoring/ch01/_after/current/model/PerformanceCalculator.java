package com.refactoring.ch01._after.current.model;

import com.refactoring.ch01._after.current.model.data.EnrichPerformance;
import com.refactoring.ch01.data.Performance;
import com.refactoring.ch01.data.Play;

public interface PerformanceCalculator {

    EnrichPerformance enrichPerformance(final Performance aPerformance, final Play aPlay);

}
