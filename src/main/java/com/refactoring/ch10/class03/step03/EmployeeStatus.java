package com.refactoring.ch10.class03.step03;

import java.util.function.Function;

public enum EmployeeStatus {
    SEPARATED("SEP", CalculatePayment.noPayment),
    RETIRED("RET", CalculatePayment.noPayment),
    NORMAL("SAL", CalculatePayment.Payment);

    private String status;
    private Function<Integer, Integer> calcPayment;

    EmployeeStatus(String status, Function<Integer, Integer> payFunction) {
        this.status = status;
        this.calcPayment = payFunction;
    }

    public String getStatus() {
        return status;
    }

    public int calcPayment(int salary) {
        return calcPayment.apply(salary);
    }


    private class CalculatePayment {
        public static Function<Integer, Integer> noPayment = (salary) -> 0;
        public static Function<Integer, Integer> Payment = (salary) -> salary / 12;
    }

}
