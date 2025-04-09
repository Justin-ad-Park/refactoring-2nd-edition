package com.refactoring.ch10.class03.step01;

import com.refactoring.ch10.class03.LocalDateFactory;
import com.refactoring.ch10.class03.Paystub;

import java.time.Month;

public class Employee02 {
    private boolean isSeparated;
    private boolean isRetired;
    private int salary;

    public Employee02(boolean isSeparated, boolean isRetired, int salary) {
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

        //일반 직원
        String reasonCode;
        int bonus = 0;
        int salary = this.salary / 12;

        if( localDate.now().getMonth() == Month.DECEMBER ) {
            bonus = (int) (this.salary * 0.1);
            reasonCode = "BONUS";
        } else {
            reasonCode = "SAL";
        }

        return new Paystub(salary , bonus, reasonCode);
    }

}
