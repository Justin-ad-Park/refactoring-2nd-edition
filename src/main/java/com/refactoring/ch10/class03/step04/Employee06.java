package com.refactoring.ch10.class03.step04;

import com.refactoring.ch10.class03.LocalDateFactory;
import com.refactoring.ch10.class03.Paystub;

import java.time.Month;

public class Employee06 {
    private EmployeeStatus status;
    private int salary;
    LocalDateFactory localDate;

    public Employee06(EmployeeStatus status, int salary, LocalDateFactory localDate) {
        this.status = status;
        this.salary = salary;
        this.localDate = localDate;
    }

    public Paystub getPaystub() {
        //급여를 지급하지 않는 직원
        if (status.isPayment() == false)
            return Paystub.noPay(status.getStatus());

        return getPayment4NormalEmployee();
    }

    private Paystub getPayment4NormalEmployee() {
        BonusMonth bonusMonth = BonusMonth.of(localDate.now().getMonth());
        return new Paystub(status.calcPayment(salary), bonusMonth.getBonus(salary), bonusMonth.getStatus());
    }

}
