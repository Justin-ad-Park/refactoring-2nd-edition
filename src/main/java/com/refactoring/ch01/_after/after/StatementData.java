package com.refactoring.ch01._after.after;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.refactoring.ch01.data.Invoice;
import com.refactoring.ch01.data.Play;

public record StatementData(
        String customer,
        List<EnrichPerformance> performances,
        int totalAmount,
        int totalVolumeCredits
) {

    public static StatementData createStatementData(final Invoice invoice, final Map<String, Play> plays) {
        final List<EnrichPerformance> performances = invoice.performances().stream()
                .map(performance -> EnrichPerformance.of(performance, plays))
                .collect(Collectors.toList());

        return new StatementData(
                invoice.customer(),
                performances,
                totalAmount(performances),
                totalVolumeCredits(performances)
        );
    }

    private static int totalAmount(final List<EnrichPerformance> performances) {
        return performances.stream()
                .mapToInt(EnrichPerformance::amount)
                .sum();
    }

    private static int totalVolumeCredits(final List<EnrichPerformance> performances) {
        return performances.stream()
                .mapToInt(EnrichPerformance::volumeCredits)
                .sum();
    }

}
