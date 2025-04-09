package com.refactoring.ch10.class03.step01;

import com.refactoring.ch10.class03.LocalDateFactory;
import com.refactoring.ch10.class03.Paystub;
import java.time.Month;

public class Employee {
    private boolean isSeparated;
    private boolean isRetired;
    private int salary;

    public Employee(boolean isSeparated, boolean isRetired, int salary) {
        this.isSeparated = isSeparated;
        this.isRetired = isRetired;
        this.salary = salary;
    }

    public Paystub getPaystub(LocalDateFactory localDate) {
        Paystub result;

        if (isSeparated) {  //퇴사한 직원
            result = new Paystub(0, 0, "SEP");
        }
        else {
            if (isRetired) {    //은퇴한 직원
                result = new Paystub(0, 0,"RET");
            }
            else {  //일반 직원
                result = new Paystub(salary / 12 , 0, "SAL");

                // 12월에는 보너스 지급 (연봉의 10%)
                if( localDate.now().getMonth() == Month.DECEMBER )
                    result = new Paystub(result.amount(), (int)(salary * 0.1) , "BONUS");

            }
        }
        return result;
    }

}
