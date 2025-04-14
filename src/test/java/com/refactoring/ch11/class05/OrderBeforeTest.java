package com.refactoring.ch11.class05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderBeforeTest {

    @DisplayName("할인이 적용된 최종 가격을 계산한다")
    @Test
    void getFinalPrice() {
        // given
        OrderBefore orderBefore = new OrderBefore(10, 1000);
        // when
        int price = orderBefore.getFinalPrice();
        // then
        Assertions.assertThat(price).isEqualTo(9500);
    }
}