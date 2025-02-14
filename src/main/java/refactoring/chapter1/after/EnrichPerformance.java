package refactoring.chapter1.after;

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
        Play play = playFor(aPerformance, plays);

        PerformanceCalculator calculator = PerformanceCalculator.createPerformanceCalculator(
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

    private static Play playFor(Performance aPerformance, Map<String, Play> plays) {
        return plays.get(aPerformance.playID());
    }

}
