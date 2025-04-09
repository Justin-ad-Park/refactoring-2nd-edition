package com.refactoring.ch10.class03.step01;

import com.refactoring.ch10.class03.LocalDateFactory;
import com.refactoring.ch10.class03.Paystub;

import java.time.Month;

public class Employee03 {
    private boolean isSeparated;
    private boolean isRetired;
    private int salary;

    public Employee03(boolean isSeparated, boolean isRetired, int salary) {
        this.isSeparated = isSeparated;
        this.isRetired = isRetired;
        this.salary = salary;
    }

    public Paystub getPaystub(LocalDateFactory localDate) {
        //퇴사한 직원
        if (isSeparated)
            return new Paystub(0, 0, "SEP");

        //은퇴한 직원
        if (isRetired)
            return new Paystub(0, 0,"RET");

        return getPaystub4Normal(localDate);
    }

    private Paystub getPaystub4Normal(LocalDateFactory localDate) {
        //일반 직원
        int amount = this.salary / 12;

        if( localDate.now().getMonth() == Month.DECEMBER ) {
            return new Paystub(amount, (int) (this.salary * 0.1), "BONUS");
        }

        return new Paystub(amount, 0, "SAL");
    }

}
