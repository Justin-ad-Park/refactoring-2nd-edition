package refactoring.chapter1.after;

import refactoring.chapter1.data.Invoice;
import refactoring.chapter1.data.Performance;
import refactoring.chapter1.data.Play;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatementVo {
    private String customer;
    private List<Performance> performances;
    private List<EnrichPerformance> enrichPerformances;

    public StatementVo(Invoice invoice, Map<String, Play> plays) {
        this.customer = invoice.customer();
        this.performances = invoice.performances();

        this.enrichPerformances = this.performances.stream()
                .map(performance -> EnrichPerformance.of(performance, plays))
                .collect(Collectors.toUnmodifiableList());
    }

    public String customer() {
        return customer;
    }

    public List<Performance> performances() {
        return performances;
    }

    public List<EnrichPerformance> enrichPerformances() {
        return enrichPerformances;
    }

    public int totalAmount() {
        return enrichPerformances.stream()
                .mapToInt(EnrichPerformance::amountFor)
                .sum();
    }

    public int totalVolumeCredits() {
        var result = 0;
        for (var perf : enrichPerformances) {
            result += volumeCreditsFor(perf);
        }
        return result;
    }

    public int volumeCreditsFor(EnrichPerformance enrichPerformance) {
        int result = 0;
        result += Math.max(enrichPerformance.audience() - 30, 0);

        // 희극 관객 5명마다 추가 포인트를 제공한다.
        if ("comedy".equals(enrichPerformance.play().type())) {
            result += Math.floor(enrichPerformance.audience() / 5);
        }
        return result;
    }

}
