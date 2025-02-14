package refactoring.chapter1.after;

import refactoring.chapter1.data.Invoice;
import refactoring.chapter1.data.Performance;
import refactoring.chapter1.data.Play;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class Statement {

    public String statement(Invoice invoice, Map<String, Play> plays) {
        StatementVo statementVo = new StatementVo(invoice, plays);

        return renderPlainText(statementVo, plays);
    }

    private static String renderPlainText(StatementVo statementVo, Map<String, Play> plays) {
        var result = new StringBuilder("청구 내역 (고객명: " + statementVo.customer() + ")\n");

        for (var perf : statementVo.enrichPerformances()) {

            // 청구 내역을 출력한다.
            result.append(
                    String.format(
                            "  %s: %s원 (%d석)\n",
                            perf.play().name(),
                            formatKRW(amountFor(perf) / 100.0),
                            perf.audience()
                    )
            );
        }

        result.append(String.format("총액: %s원\n", formatKRW(totalAmount(statementVo.enrichPerformances(), plays) / 100.0)));
        result.append(String.format("적립 포인트: %d점\n", totalVolumeCredits(statementVo.performances(), plays)));

        return result.toString();
    }

    private static int totalAmount(List<EnrichPerformance> performances, Map<String, Play> plays) {
        var result = 0;
        for (var perf : performances) {
            final Play play = plays.get(perf.playID());

            result += amountFor(perf);
        }
        return result;
    }

    private static int totalVolumeCredits(List<Performance> performances, Map<String, Play> plays) {
        var result = 0;
        for (var perf : performances) {
            final Play play = plays.get(perf.playID());

            result += volumeCreditsFor(perf, play);
        }
        return result;
    }

    private static String formatKRW(double number) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(number);
    }

    private static int volumeCreditsFor(Performance aPerformance,  Play play) {
        int result = 0;
        result += Math.max(aPerformance.audience() - 30, 0);

        // 희극 관객 5명마다 추가 포인트를 제공한다.
        if ("comedy".equals(play.type())) {
            result += Math.floor(aPerformance.audience() / 5);
        }
        return result;
    }

    private static int amountFor(EnrichPerformance aPerformance) {
        int result;

        switch (aPerformance.play().type()) {
            case "tragedy":
                result = 40000;
                if (aPerformance.audience() > 30) {
                    result += 1000 * (aPerformance.audience() - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (aPerformance.audience() > 20) {
                    result += 10000 + 500 * (aPerformance.audience() - 20);
                }
                result += 300 * aPerformance.audience();
                break;
            default:
                throw new IllegalArgumentException("알 수 없는 장르: " + aPerformance.play().type());
        }
        return result;
    }

}
