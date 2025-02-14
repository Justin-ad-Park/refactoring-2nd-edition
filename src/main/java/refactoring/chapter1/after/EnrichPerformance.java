package refactoring.chapter1.after;

import refactoring.chapter1.data.Performance;
import refactoring.chapter1.data.Play;

import java.util.Map;

public record EnrichPerformance(
        String playID,
        int audience,
        Play play) {

    public static EnrichPerformance of(final Performance aPerformance, final Map<String, Play> plays) {
        return new EnrichPerformance(
                aPerformance.playID(),
                aPerformance.audience(),
                playFor(aPerformance, plays)
        );
    }

    private static Play playFor(Performance aPerformance, Map<String, Play> plays) {
        return plays.get(aPerformance.playID());
    }
}
