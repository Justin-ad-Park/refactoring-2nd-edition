package refactoring.chapter1.after;

import refactoring.chapter1.data.Invoice;
import refactoring.chapter1.data.Play;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class Statement {

    public String statement(Invoice invoice, Map<String, Play> plays) {
        StatementVo statementVo = new StatementVo(invoice, plays);

        return renderPlainText(statementVo);
    }

    private static String renderPlainText(StatementVo statementVo) {
        var result = new StringBuilder("청구 내역 (고객명: " + statementVo.customer() + ")\n");

        for (var perf : statementVo.enrichPerformances()) {

            // 청구 내역을 출력한다.
            result.append(
                    String.format(
                            "  %s: %s원 (%d석)\n",
                            perf.play().name(),
                            formatKRW(perf.amountFor() / 100.0),
                            perf.audience()
                    )
            );
        }

        result.append(String.format("총액: %s원\n", formatKRW(statementVo.totalAmount() / 100.0)));
        result.append(String.format("적립 포인트: %d점\n", totalVolumeCredits(statementVo.enrichPerformances())));

        return result.toString();
    }

    private static int totalVolumeCredits(List<EnrichPerformance> enrichPerformances) {
        var result = 0;
        for (var perf : enrichPerformances) {
            result += volumeCreditsFor(perf);
        }
        return result;
    }

    private static String formatKRW(double number) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(number);
    }

    private static int volumeCreditsFor(EnrichPerformance enrichPerformance) {
        int result = 0;
        result += Math.max(enrichPerformance.audience() - 30, 0);

        // 희극 관객 5명마다 추가 포인트를 제공한다.
        if ("comedy".equals(enrichPerformance.play().type())) {
            result += Math.floor(enrichPerformance.audience() / 5);
        }
        return result;
    }


}
