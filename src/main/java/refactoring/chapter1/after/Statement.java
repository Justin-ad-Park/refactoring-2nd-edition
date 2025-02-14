package refactoring.chapter1.after;

import refactoring.chapter1.data.Invoice;
import refactoring.chapter1.data.Play;

import java.text.NumberFormat;
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
            result.append(
                    String.format(
                            "  %s: %s원 (%d석)\n",
                            perf.play().name(),
                            formatKRW(perf.amount() / 100.0),
                            perf.audience()
                    )
            );
        }

        result.append(String.format("총액: %s원\n", formatKRW(statementVo.totalAmount() / 100.0)));
        result.append(String.format("적립 포인트: %d점\n",statementVo.totalVolumeCredits()));

        return result.toString();
    }


    private static String formatKRW(double number) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(number);
    }


}
