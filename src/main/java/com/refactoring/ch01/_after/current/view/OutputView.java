package com.refactoring.ch01._after.current.view;

import java.text.NumberFormat;
import java.util.Locale;
import com.refactoring.ch01._after.current.model.data.Statement;

public class OutputView {

    public static final String LF = System.lineSeparator();
    public static final NumberFormat US_CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    public String renderPlainText(final Statement statement) {
        var result = new StringBuilder("청구 내역 (고객명: " + statement.customer() + ")").append(LF);

        for (var perf : statement.performances()) {
            result.append(String.format(
                    "  %s: %s원 (%d석)",
                    perf.playName(),
                    usd(perf.amount()),
                    perf.audience()
            )).append(LF);
        }

        result.append(String.format("총액: %s원", usd(statement.totalAmount()))).append(LF);
        result.append(String.format("적립 포인트: %d점", statement.totalVolumeCredits())).append(LF);

        return result.toString();
    }

    public String renderHtml(final Statement statement) {
        var result = new StringBuilder(String.format("<h1>청구 내역 (고객명: %s)</h1>", statement.customer())).append(LF);
        result.append("<table>").append(LF);
        result.append("  <tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>").append(LF);
        for (var perf : statement.performances()) {
            result.append(String.format("  <tr><td>%s</td><td>%s</td>", perf.playName(), perf.audience()));
            result.append(String.format("<td>%s</td></tr>", usd(perf.amount()))).append(LF);
        }
        result.append("</table>").append(LF);
        result.append(String.format("<p>총액: <em>%s</em></p>", usd(statement.totalAmount()))).append(LF);
        result.append(String.format("<p>적립 포인트: <em>%s</em>점</p>", statement.totalVolumeCredits())).append(LF);

        return result.toString();
    }

    private String usd(final int amount) {
        return US_CURRENCY_FORMAT.format(amount / 100);
    }

}
