package com.refactoring.ch06._01_extractFunction.practice._02;

public class Owing {
    private Invoice invoice;

    public Owing(Invoice invoice) {
        this.invoice = invoice;
    }

    public String printOwing01() {
        var outstanding = 0;

        StringBuilder result = new StringBuilder();
        result.append(getBanner());
        outstanding = getOutstanding();
        result.append(getDetails(invoice, outstanding));

        return result.toString();
    }

    // calculate outstanding(outstanding = 미수금)
    private int getOutstanding() {
        return invoice.getOrders().stream()
                .mapToInt(Order::getAmount)
                .sum();
    }

    private String getDetails(Invoice invoice, int outstanding) {
        StringBuilder result = new StringBuilder();

        result.append("name: " + invoice.getCustomer() + "\n");
        result.append("amount: " + outstanding + "\n");
        result.append("due date: " + invoice.getDueDate()+ "\n");

        return result.toString();
    }

    private static String getBanner() {
        return """
                ***********************
                **** Customer Owes ****
                ***********************
                """;
    }
}
