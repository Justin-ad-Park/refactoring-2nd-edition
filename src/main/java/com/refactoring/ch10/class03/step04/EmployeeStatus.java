package com.refactoring.ch10.class03.step04;

import java.util.function.Function;

public enum EmployeeStatus {
    SEPARATED("SEP", false,  CalculatePayment.noPayment),
    RETIRED("RET", false, CalculatePayment.noPayment),
    NORMAL("SAL", true, CalculatePayment.Payment);

    private String status;
    private boolean isPayment;
    private Function<Integer, Integer> calcPayment;

    EmployeeStatus(String status, Boolean isPayment, Function<Integer, Integer> payFunction) {
        this.status = status;
        this.isPayment = isPayment;
        this.calcPayment = payFunction;
    }

    public String getStatus() {
        return status;
    }

    public int calcPayment(int salary) {
        return calcPayment.apply(salary);
    }

    public boolean isPayment() {
        return isPayment;
    }


    private class CalculatePayment {
        public static Function<Integer, Integer> noPayment = (salary) -> 0;
        public static Function<Integer, Integer> Payment = (salary) -> salary / 12;
    }

}
