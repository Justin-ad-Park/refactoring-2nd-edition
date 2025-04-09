package com.refactoring.ch10.class03.origin;

import com.refactoring.ch10.class03.Paystub;

import java.time.LocalDate;
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

    public Paystub getPaystub() {
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
                if( LocalDate.now().getMonth() == Month.SEPTEMBER )
                    result = new Paystub(result.amount(), (int)(salary * 0.1) , "BONUS");

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Employee employee = new Employee(false, false, 48000000);
        Paystub paystub = employee.getPaystub();
        System.out.println("Paystub Amount: " + paystub.amount());
        System.out.println("Paystub Bonus: " + paystub.bonus());
        System.out.println("Paystub Reason Code: " + paystub.reasonCode());
    }
}
