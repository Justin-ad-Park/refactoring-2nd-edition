package refactoring.chapter1._after.current.model;

import refactoring.chapter1._after.current.model.data.EnrichPerformance;
import refactoring.chapter1.data.Performance;
import refactoring.chapter1.data.Play;

public interface PerformanceCalculator {

    EnrichPerformance enrichPerformance(final Performance aPerformance, final Play aPlay);

}
