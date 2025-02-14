package refactoring.chapter1.after.calculator;

import refactoring.chapter1.data.Play;

public class ComedyPerformanceCalculator implements PerformanceCalculator {
    final int audience;
    final Play play;

    public ComedyPerformanceCalculator(int audience, Play play) {
        this.audience = audience;
        this.play = play;
    }

    @Override
    public int amount() {
        int result;

        switch (play.type()) {
            case "tragedy":
                result = 40000;
                if (audience > 30) {
                    result += 1000 * (audience - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (audience > 20) {
                    result += 10000 + 500 * (audience - 20);
                }
                result += 300 * audience;
                break;
            default:
                throw new IllegalArgumentException("알 수 없는 장르: " + play.type());
        }
        return result;
    }

    @Override
    public int volumeCredits() {
        int result = 0;
        result += Math.max(audience - 30, 0);

        // 희극 관객 5명마다 추가 포인트를 제공한다.
        if ("comedy".equals(play.type())) {
            result += Math.floor(audience / 5);
        }
        return result;
    }}
