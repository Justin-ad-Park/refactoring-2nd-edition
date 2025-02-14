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

    public int amountFor() {
        int result;

        switch (play().type()) {
            case "tragedy":
                result = 40000;
                if (audience() > 30) {
                    result += 1000 * (audience() - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (audience() > 20) {
                    result += 10000 + 500 * (audience() - 20);
                }
                result += 300 * audience();
                break;
            default:
                throw new IllegalArgumentException("알 수 없는 장르: " + play().type());
        }
        return result;
    }
}
