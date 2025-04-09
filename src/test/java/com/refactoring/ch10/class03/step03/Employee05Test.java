package com.refactoring.ch10.class03.step03;

import com.refactoring.ch10.class03.LocalDateFactory;
import com.refactoring.ch10.class03.Paystub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import static org.mockito.BDDMockito.given;

class Employee05Test {

    @DisplayName("pay 값을 계산한다")
    @Test
    void getPayAmount_평월(){
        // given
        Employee06 Employee05 = new Employee06(EmployeeStatus.NORMAL, 48000000);
        LocalDateFactory localDate = Mockito.mock(LocalDateFactory.class);
        given(localDate.now()).willReturn(LocalDate.of(2025, 1, 1));

        // when
        Paystub paystub = Employee05.getPaystub(localDate);
        // then
        Assertions.assertEquals(4000000, paystub.amount());
        Assertions.assertEquals(0, paystub.bonus());
    }

    @Test
    void getPayAmount_12월보너스(){
        // given
        Employee06 Employee05 = new Employee06(EmployeeStatus.NORMAL, 48000000);
        LocalDateFactory localDate = Mockito.mock(LocalDateFactory.class);
        given(localDate.now()).willReturn(LocalDate.of(2025, 12, 1));

        // when
        Paystub paystub = Employee05.getPaystub(localDate);
        // then
        Assertions.assertEquals(4000000, paystub.amount());
        Assertions.assertEquals(4800000, paystub.bonus());
    }

    @Test
    void getPayAmount_은퇴직원(){
        // given
        Employee06 Employee05 = new Employee06(EmployeeStatus.RETIRED, 100000000);
        LocalDateFactory localDate = Mockito.mock(LocalDateFactory.class);
        given(localDate.now()).willReturn(LocalDate.of(2025, 12, 1));

        // when
        Paystub paystub = Employee05.getPaystub(localDate);
        // then
        Assertions.assertEquals(0, paystub.amount());
        Assertions.assertEquals(0, paystub.bonus());
    }
}