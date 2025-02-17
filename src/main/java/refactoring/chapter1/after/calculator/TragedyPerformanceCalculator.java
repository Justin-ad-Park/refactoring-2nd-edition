package refactoring.chapter1.after.calculator;

import refactoring.chapter1.data.Play;

public class TragedyPerformanceCalculator implements PerformanceCalculator {
    final int audience;
    final Play play;

    protected TragedyPerformanceCalculator(int audience, Play play) {
        this.audience = audience;
        this.play = play;
    }

    @Override
    public int amount() {
        int result = 40000;
        if (audience > 30) result += 1000 * (audience - 30);

        return result;
    }

    @Override
    public int volumeCredits () {
        return volumeCredits(audience);
    }
}