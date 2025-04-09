package com.refactoring.ch10.class03.step03;

import com.refactoring.ch10.class03.LocalDateFactory;
import com.refactoring.ch10.class03.Paystub;

import java.time.Month;

public class Employee06 {
    private EmployeeStatus status;
    private int salary;

    public Employee06(EmployeeStatus status, int salary) {
        this.status = status;
        this.salary = salary;
    }

    public Paystub getPaystub(LocalDateFactory localDate) {
        //퇴사한 직원, 은퇴한 직원
        if (status == EmployeeStatus.SEPARATED || status == EmployeeStatus.RETIRED)
            return new Paystub(status.calcPayment(salary), 0, status.getStatus());

        //일반 직원
        return getPaystub4Normal(localDate);
    }

    //일반 직원
    private Paystub getPaystub4Normal(LocalDateFactory localDate) {
        int amount = status.calcPayment(this.salary);

        if( localDate.now().getMonth() == Month.DECEMBER ) {
            return new Paystub(amount, (int) (this.salary * 0.1), "BONUS");
        }

        return new Paystub(amount, 0, status.getStatus());
    }

}
