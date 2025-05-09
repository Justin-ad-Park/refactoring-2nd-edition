package com.refactoring.ch01._after.current.model;

import java.util.List;
import java.util.Map;
import com.refactoring.ch01._after.current.model.data.EnrichPerformance;
import com.refactoring.ch01._after.current.model.data.Statement;
import com.refactoring.ch01.data.Invoice;
import com.refactoring.ch01.data.Play;

public class StatementFactory {

    private final PerformanceCalculator calculator;

    public StatementFactory(final PerformanceCalculator performanceCalculator) {
        this.calculator = performanceCalculator;
    }

    public Statement createStatement(final Invoice invoice, final Map<String, Play> plays) {
        final List<EnrichPerformance> enrichPerformances = invoice.performances().stream()
                .map(performance -> calculator.enrichPerformance(performance, plays.get(performance.playID())))
                .toList();

        return new Statement(
                invoice.customer(),
                enrichPerformances,
                totalAmount(enrichPerformances),
                totalVolumeCredits(enrichPerformances)
        );
    }

    private int totalAmount(final List<EnrichPerformance> performances) {
        return performances.stream()
                .mapToInt(EnrichPerformance::amount)
                .sum();
    }

    private int totalVolumeCredits(final List<EnrichPerformance> performances) {
        return performances.stream()
                .mapToInt(EnrichPerformance::volumeCredits)
                .sum();
    }

}
