package com.refactoring.ch06._01_extractFunction.practice._02;

public class Owing {
    private final Invoice invoice;
    private final int outstanding;

    public Owing(Invoice invoice) {
        this.invoice = invoice;
        this.outstanding = getOutstanding();
    }

    public String printOwing01() {
        StringBuilder result = new StringBuilder();
        result.append(getBanner());
        result.append(getDetails());

        return result.toString();
    }

    // calculate outstanding(outstanding = 미수금)
    private int getOutstanding() {
        return invoice.getOrders().stream()
                .mapToInt(Order::getAmount)
                .sum();
    }

    private String getDetails() {
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
