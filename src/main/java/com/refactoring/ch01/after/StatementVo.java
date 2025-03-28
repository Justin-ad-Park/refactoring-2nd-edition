package com.refactoring.ch01.after;

import com.refactoring.ch01.data.Invoice;
import com.refactoring.ch01.data.Performance;
import com.refactoring.ch01.data.Play;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatementVo {
    private String customer;
    private List<EnrichPerformance> enrichPerformances;

    public StatementVo(Invoice invoice, Map<String, Play> plays) {
        this.customer = invoice.customer();
        List<Performance> performances = invoice.performances();

        this.enrichPerformances = performances.stream()
                .map(performance -> EnrichPerformance.of(performance, plays))
                .collect(Collectors.toList());
    }

    public String customer() {
        return customer;
    }

//    public List<Performance> performances() {
//        return performances;
//    }

    public List<EnrichPerformance> enrichPerformances() {
        return enrichPerformances;
    }

    public int totalAmount() {
        return enrichPerformances.stream()
                .mapToInt(EnrichPerformance::amount)
                .sum();
    }

    public int totalVolumeCredits() {
        return enrichPerformances.stream()
                .mapToInt(EnrichPerformance::volumeCredits)
                .sum();
    }


}
