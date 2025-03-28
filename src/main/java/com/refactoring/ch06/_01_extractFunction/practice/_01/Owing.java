package com.refactoring.ch06._01_extractFunction.practice._01;

public class Owing {
    public String printOwing01(Invoice invoice) {
        var outstanding = 0;

        StringBuilder result = new StringBuilder();
        result.append("""
        ***********************
        **** Customer Owes ****
        ***********************
        """);


        // calculate outstanding(outstanding = 미수금)
        for (Order order : invoice.getOrders()) {
            outstanding += order.getAmount();
        }

        result.append("name: " + invoice.getCustomer() + "\n");
        result.append("amount: " + outstanding + "\n");
        result.append("due date: " + invoice.getDueDate()+ "\n");

        return result.toString();
    }
}
