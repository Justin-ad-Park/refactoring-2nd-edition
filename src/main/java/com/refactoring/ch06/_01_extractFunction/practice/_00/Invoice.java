package com.refactoring.ch06._01_extractFunction.practice._00;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
    private final String customer;
    private final List<Order> orders;

    public String getCustomer() {
        return customer;
    }

    public List<Order> getOrders() {
        return orders;
    }

    private LocalDate dueDate;

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Invoice(String customer, List<Order> orders) {
        this.customer = customer;
        this.orders = orders;
        this.dueDate = LocalDate.now().plusDays(30);
    }

}
