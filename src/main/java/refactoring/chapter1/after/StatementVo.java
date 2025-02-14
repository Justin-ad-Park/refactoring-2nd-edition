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
                .collect(Collectors.toList());
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
        return enrichPerformances.stream()
                .mapToInt(EnrichPerformance::volumeCreditsFor)
                .sum();
    }


}
