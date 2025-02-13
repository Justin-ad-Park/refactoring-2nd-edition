package refactoring.chapter1.after;

import refactoring.chapter1.data.Invoice;
import refactoring.chapter1.data.Performance;
import refactoring.chapter1.data.Play;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;


public class Statement {

    public String statement(Invoice invoice, Map<String, Play> plays) {
        var totalAmount = 0;
        var result = new StringBuilder("청구 내역 (고객명: " + invoice.customer() + ")\n");

        for (var perf : invoice.performances()) {
            final Play play = plays.get(perf.playID());

            // 청구 내역을 출력한다.
            result.append(
                    String.format(
                            "  %s: %s원 (%d석)\n",
                            play.name(),
                            formatKRW(amountFor(perf, play) / 100.0),
                            perf.audience()
                    )
            );
            totalAmount += amountFor(perf, play);
        }

        var volumeCredits = 0;  // <- 변수 선언을 반복문 앞으로 이동, Slide Statements(리팩터링 8.6 문장 슬라이드하기)
        for (var perf : invoice.performances()) {   // <- 값 누적 로직을 별도 for문으로 분리
            final Play play = plays.get(perf.playID());

            volumeCredits += volumeCreditsFor(perf, play);
        }

        result.append(String.format("총액: %s원\n", formatKRW(totalAmount / 100.0)));
        result.append(String.format("적립 포인트: %d점\n", volumeCredits));

        return result.toString();
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

    private static int amountFor(Performance aPerformance, Play play) {
        var result = 0;

        switch (play.type()) {
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
                throw new IllegalArgumentException("알 수 없는 장르: " + play.type());
        }
        return result;
    }

}
