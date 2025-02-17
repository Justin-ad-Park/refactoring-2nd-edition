package refactoring.chapter1.after.calculator;

import refactoring.chapter1.data.Play;

public class ComedyPerformanceCalculator implements PerformanceCalculator {
    final int audience;
    final Play play;

    protected ComedyPerformanceCalculator(int audience, Play play) {
        this.audience = audience;
        this.play = play;
    }

    @Override
    public int amount() {
        int result = 30000;
        if (audience > 20) result += 10000 + 500 * (audience - 20);


        result += 300 * audience;

        return result;
    }

    @Override
    public int volumeCredits() {
        int result = volumeCredits(audience);
        result += Math.floor(audience / 5);
        
        return result;
    }
}
