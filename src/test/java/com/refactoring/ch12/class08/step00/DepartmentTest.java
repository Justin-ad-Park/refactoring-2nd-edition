package com.refactoring.ch12.class08.step00;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepartmentTest {
    @Test
    void getTotalAnnualCost() {
        // given
        Department department = new Department("인사부", List.of(
                new Employee("회사원A", 1, 100),
                new Employee("회사원B", 2, 200),
                new Employee("회사원C", 3, 300)
        ));
        // when
        int cost = department.getAnnualCost();
        // then
        Assertions.assertThat(cost).isEqualTo((100 + 200 + 300) * 12);
    }
}