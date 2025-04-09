package com.refactoring.ch10.class03.step02;

public enum EmployeeStatus {
    SEPARATED("SEP", false),
    RETIRED("RET", false),
    NORMAL("SAL", true);

    private String status;
    private boolean isPayment;

    EmployeeStatus(String status, boolean isPayment) {
        this.status = status;
        this.isPayment = isPayment;
    }

    public String getStatus() {
        return status;
    }

    public boolean isPayment() {
        return isPayment;
    }
}
