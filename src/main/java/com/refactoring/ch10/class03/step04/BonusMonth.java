package com.refactoring.ch10.class03.step04;

import java.time.Month;
import java.util.Arrays;
import java.util.function.Function;

public enum BonusMonth {
    DECEMBER (Month.DECEMBER, "BONUS", bonun10Percent()),
    DEFAULT (null, "SAL", noBonus())
    ;

    private static Function<Integer, Integer> bonun10Percent() {
        return (salary) -> (int) (salary * 0.1);
    }

    private static Function<Integer, Integer> noBonus() {
        return salary -> Integer.valueOf(0);
    }

    public static BonusMonth of(Month month) {
        return Arrays.stream(BonusMonth.values())
                .filter(bonusMonth -> bonusMonth.getMonth() == month)
                .findFirst()
                .orElse(DEFAULT);
    }

    private Month month;
    private String status;
    private Function<Integer, Integer> calcBonus;

    BonusMonth(Month month, String status, Function<Integer, Integer> calcBonus) {
        this.month = month;
        this.status = status;
        this.calcBonus  = calcBonus;
    }

    public Month getMonth() {
        return month;
    }

    public String getStatus() {
        return status;
    }

    public int getBonus(int salary) {
        return calcBonus.apply(salary);
    }
}
