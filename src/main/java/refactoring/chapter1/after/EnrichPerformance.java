package refactoring.chapter1.after;

import refactoring.chapter1.after.calculator.CalculatorFactory;
import refactoring.chapter1.after.calculator.PerformanceCalculator;
import refactoring.chapter1.data.Performance;
import refactoring.chapter1.data.Play;

import java.util.Map;

public record EnrichPerformance(
        String playID,
        int audience,
        Play play,
        int amount,
        int volumeCredits) {

    public static EnrichPerformance of(final Performance aPerformance, final Map<String, Play> plays) {
        Play play = getPlay(aPerformance, plays);

        PerformanceCalculator calculator = CalculatorFactory.createPerformanceCalculator(
                aPerformance.audience(),
                play
        );

        return new EnrichPerformance(
                aPerformance.playID(),
                aPerformance.audience(),
                play,
                calculator.amount(),
                calculator.volumeCredits()
        );
    }

    private static Play getPlay(Performance aPerformance, Map<String, Play> plays) {
        return plays.get(aPerformance.playID());
    }

}
